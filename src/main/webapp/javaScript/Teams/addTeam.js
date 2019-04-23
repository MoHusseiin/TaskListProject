$(function () {
    $("#frmTeam").submit(function (event) {
        let txtTeamName = $("#txtTeamName").val();
        let txtProjectName = $("#txtProjectName").val();
       // let slUserType = $("#slUserType").val();

        let isValid = true;
        let err = $("#err");
        err.empty();
        let message = $("<ul>");
        if (!txtTeamName) {
            isValid = false;
            message.append("<li>Please Enter Team Name</li>");
        }
        if (!txtProjectName) {
            isValid = false;
            message.append("<li>Please Enter Project Name</li>");
        }
        // if (!slUserType) {
        //     isValid = false;
        //     message.append("<li>Please Enter Select User Type</li>");
        // }

        if (!isValid) {
            event.preventDefault();
            err.append(message);
        }



    });
});