$(function () {
    $("#frmUser").submit(function (event) {
        let txtUserName = $("#txtUserName").val();
        let txtPassword = $("#txtPassword").val();
        let slUserType = $("#slUserType").val();
        let isValid = true;
        let err = $("#err");
        err.empty();
        let message = $("<ul>");
        if (!txtUserName) {
            isValid = false;
            message.append("<li>Please Enter User Name</li>");
        }
        if (!txtPassword) {
            isValid = false;
            message.append("<li>Please Enter Password</li>");
        }
        if (!slUserType) {
            isValid = false;
            message.append("<li>Please Enter Select User Type</li>");
        }

        if (!isValid) {
            event.preventDefault();
            err.append(message);
        }



    });
});