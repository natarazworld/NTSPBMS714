package com.nt.bo;

import lombok.Data;

@Data
public class EmployeeBO {
        private Integer empNo;
        private String ename;
        private  String job;
        private  Double sal;
        private  Integer deptNo;
        private  Integer mgrNo;
}
