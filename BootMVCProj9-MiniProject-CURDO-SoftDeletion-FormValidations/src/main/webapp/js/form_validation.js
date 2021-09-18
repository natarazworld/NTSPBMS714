 
function  validate(frm){
	alert("from java script:: Client side form validations");
	// empty form validation error message
	   document.getElementById("enameErr").innerHTML="";
       document.getElementById("jobErr").innerHTML="";
       document.getElementById("salErr").innerHTML="";
       document.getElementById("deptnoErr").innerHTML="";
	//read form data
	let name=frm.ename.value;
	let desg=frm.job.value;
	let salary=frm.sal.value;
	let deptno=frm.deptno.value;
	let validationFlag=true;
	
	//form validation logics (client side)
	if(name==""){  //required rule
	    document.getElementById("enameErr").innerHTML="Employee name is required(cs)";
           validationFlag=false;
      }
   else if(name.length()<5){  // min length rule
	      document.getElementById("enameErr").innerHTML="Employee name must have minimum of 5 characters(cs)";
           validationFlag=false;
    }

if(desg==""){  //required rule
	    document.getElementById("jobErr").innerHTML="Employee Desg  is required(cs)";
           validationFlag=false;
      }
   else if(desg.length()<5){  // min length rule
	      document.getElementById("jobErr").innerHTML="Employee desg must have minimum of 5 characters(cs)";
        validationFlag=false;
    }

if(salary==""){  //required rule
	    document.getElementById("salErr").innerHTML="Employee Salary  is required(cs)";
           validationFlag=false;
      }
   else if(isNaN(salary)){  // numeric rule
	      document.getElementById("salErr").innerHTML="Employee salary must be numeric value(cs)";
        validationFlag=false;
    }
  else if(salary<10000  || salary>1000000){  //range rule
	      document.getElementById("salErr").innerHTML="Employee salary must be given in the range of 10000 to 1000000(cs)";
        validationFlag=false;
}

if(deptno==""){  //required rule
	    document.getElementById("deptnoErr").innerHTML="Employee Dept number  is required(cs)";
           validationFlag=false;
      }
   else if(isNaN(deptno)){  // numeric rule
	      document.getElementById("deptnoErr").innerHTML="Employee deptno must be numeric value(cs)";
        validationFlag=false;
    }
  else if(deptno<10  || deptno>1000){  //range rule
	      document.getElementById("deptnoErr").innerHTML="Employee salary must be given in the range of 10000 to 1000000(cs)";
        validationFlag=false;
}
//  changing vflag (hidden box value 'yes' indicating client side form validations are performed)
  frm.vflag.value="yes";

return validationFlag;

}
	
