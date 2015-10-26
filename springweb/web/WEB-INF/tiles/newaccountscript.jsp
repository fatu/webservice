<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">

  function onload() {

    $("#password").keyup(checkPasswordsMatch);
    $("#confirmpass").keyup(checkPasswordsMatch);

    $("#details").submit(canSubmit);

  }

  function canSubmit() {
    var password = $("#password").val();
    var confirmpass = $("#confirmpass").val();

    if (password != confirmpass) {
      alert("Password do not match.")
      return false;
    }
    else {
      return true;
    }
  }

  function checkPasswordsMatch() {
    var password = $("#password").val();
    var confirmpass = $("#confirmpass").val();

    if (password.length > 3 || confirmpass.length > 3) {


      if (password == confirmpass) {
        $("#matchpass").text("<fmt:message key='MatchedPasswords.user.password'/>");
        $("#matchpass").addClass("valid");
        $("#matchpass").removeClass("error");

      } else {
        $("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password'/>");
        $("#matchpass").addClass("error");
        $("#matchpass").removeClass("valid");
      }
    }

  }

  $(document).ready(onload);

</script>