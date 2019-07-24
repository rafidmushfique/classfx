/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author immah
 */
public class ResultSubject {
    private final SimpleStringProperty subjectId;
    private final SimpleStringProperty courseId;
     public ResultSubject(String subId, String courId) {
        subjectId = new SimpleStringProperty(subId);
        courseId = new SimpleStringProperty(courId);
     }
     public String getCourseId() {
        return courseId.get();
    }

    public void setCourseId(String courId) {
        courseId.set(courId);
    }
    
    
    
    public String getSubjectId() {
        return subjectId.get();
    }

    public void setSubjectId(String subId) {
        subjectId.set(subId);
    }
}
