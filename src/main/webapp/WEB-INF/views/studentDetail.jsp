<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="bootstrap.min.css" rel="stylesheet" />
    <script src="bootstrap.min.js"></script>
    <script src="jquery.3.6.min.js"></script>
    <title>Detail Student</title>
  </head>
  <body>
    <div class="container mb-4">
      <div class="row m-auto">
        <div class="col-8 m-auto">
          <table class="table table-borderless">
            <thead>
              <tr class="text-center">
                <th colspan="2">
                  <h2 class="mt-2 mb-2">Student Detail</h2>
                </th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td scope="row">StudentID</td>
                <td>${student.id}</td>
              </tr>
              <tr>
                <td scope="row">Name</td>
                <td>${student.name}</td>
              </tr>
              <tr>
                <td scope="row">Male</td>
                <td>
                  <input
                    class="form-check-input"
                    type="checkbox"
                    id="male"
                    disabled
                    value="${student.male}"
                    checked
                  />
                </td>
              </tr>
              <tr>
                <td scope="row">Birthday</td>
                <td><span id="birthday">${student.birthday}</span></td>
              </tr>
              <tr>
                <td>Place of birth</td>
                <td>${student.placeOfBirth}</td>
              </tr>
              <tr>
                <td scope="row">Address</td>
                <td>${student.address}</td>
              </tr>
              <tr>
                <td scope="row">Department</td>
                <td>${student.depName}</td>
              </tr>
              <tr class="mb-4">
                <td class="text-start" colspan="2">
                  <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/'">
                    Student list
                  </button>
                  <button type="button" class="btn btn-outline-secondary" onclick="window.location.href='/student-edit-${student.id}'">
                    Edit student
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</html>
<script>
$(document).ready(function(){
	let isMale =  ($("#male").val() === 'true');
	$("#male").prop('checked', isMale);
});
$(document).ready(function(){
	var date = new Date('2010-10-11T00:00:00+05:30');
	console.log(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '/' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '/' + date.getFullYear());
});
function formatDate(date){
	if(date != null && date != ""){
		var d = new Date(date);
	    var day = d.getDate();
	    var month = d.getMonth() + 1;
	    var year = d.getFullYear();
	    if (day < 10) {
	        day = "0" + day;
	    }
	    if (month < 10) {
	        month = "0" + month;
	    }
	    return day + "-" + month + "-" + year;
	}
	return "";
}
$(document).ready(function(){
	let birthday =  $("#birthday").text() ;
	let formatBirthday = formatDate(birthday);
	$("#birthday").text(formatBirthday);
	console.log(formatBirthday)
});
</script>
