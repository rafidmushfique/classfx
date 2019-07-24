/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author RafiD
 */
public class addcoursetable {
        private final SimpleStringProperty courseid;
  //  private final SimpleStringProperty courseNumber;

    public addcoursetable(String courseid) {
        this.courseid = new SimpleStringProperty (courseid);
        
    }
    public String getCourseid()
    {
    return courseid.get();
    }
    public void setCourseid(String a)
    {
    courseid.set(a);
    }
}
