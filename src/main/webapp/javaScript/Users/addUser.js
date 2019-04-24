$(function () {
   let usrTypeId= $("#UserTypeID").val();
   if(usrTypeId){
       $("#slUserType").val(usrTypeId);
   }
    $("#frmUser").submit(function (event) {
        let txtUserName = $("#txtUserName").val();
        let txtPassword = $("#txtPassword").val();
        let slUserType = $("#slUserType").val();
        let txtName = $("#txtName").val();

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
        if (slUserType <0) {
            isValid = false;
            message.append("<li>Please Select User Type</li>");
        }
        if (!txtName) {
            isValid = false;
            message.append("<li>Please Enter Name</li>");
        }
        if (!isValid) {
            event.preventDefault();
            err.append(message);
        }



    });
});