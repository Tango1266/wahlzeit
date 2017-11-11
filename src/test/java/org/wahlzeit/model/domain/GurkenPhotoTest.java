package org.wahlzeit.model.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.Location;
import org.wahlzeit.model.Photo;

public class GurkenPhotoTest extends DomainTest {

    String cucumberType;
    int avgSizeInMillimeter;
    Location noWhere;

    @Before
    public void setUp() {
        noWhere=new Location();
        avgSizeInMillimeter=120;
        cucumberType="cucumber";
    }

    @Test
    public void createGurkenPhoto_inEmptyConstructor_notNull(){
        GurkenPhoto gurkenPhoto= new GurkenPhoto();
        Assert.assertNotNull(gurkenPhoto);
    }

    @Test
    public void createGurkenPhoto_fullyDefined_attributesNotNull(){
        GurkenPhoto gurkenPhoto = new GurkenPhoto();
        gurkenPhoto.setLocation(noWhere);
        gurkenPhoto.setType(cucumberType);
        gurkenPhoto.setSize(avgSizeInMillimeter);
        gurkenPhoto.setTaste(Taste.TASTELESS);

        assertAttribuesAreAsExpected(gurkenPhoto);
    }

    @Test
    public void createGurkenPhoto_throughConstructucter_attributesNotNull(){
        GurkenPhoto gurkenPhoto = new GurkenPhoto(cucumberType, avgSizeInMillimeter, Taste.TASTELESS, noWhere);
        assertAttribuesAreAsExpected(gurkenPhoto);
    }

    private void assertAttribuesAreAsExpected(GurkenPhoto gurkenPhoto) {
        Assert.assertNotNull(gurkenPhoto.getLocation());
        Assert.assertEquals(cucumberType, gurkenPhoto.getType());
        Assert.assertEquals(avgSizeInMillimeter, gurkenPhoto.getSize());
        Assert.assertEquals(Taste.TASTELESS, gurkenPhoto.getTaste());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createGurkenPhoto_withNumbersAsType_ShouldThrowException(){
        new GurkenPhoto().setType("1234fu");
    }


    @Test
    public void createGurkenPhoto_withLiteralsAsType_ShouldNotThrowException(){
       try{
           new GurkenPhoto().setType("bar");
       }catch (Exception exception){
           Assert.fail("Exception was thrown whereas no exception was expected");
       }
    }

    @Test
    public void gurkenPhoto_isSubclassOfPhoto_true(){
        Assert.assertTrue(Photo.class.isAssignableFrom(GurkenPhoto.class));
    }
}