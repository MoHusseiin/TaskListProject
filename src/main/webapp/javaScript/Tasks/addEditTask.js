$(function () {

  $("#lstCategory").val($("#catId").val());
  $("#lstPriority").val($("#prioId").val());
  let taskId = $("#taskId").val();
  //if(taskId)
  $("#headerText").val("<h1>Edit Existing Task <small>Edit Task</small></h1>");


  $("#frmTask").submit(function (event) {
    let lstCat = $("#lstCategory").val();
    let CurrentDate = new Date();
    CurrentDate.setHours(0,0,0,0);
    let dueDate = $("#txtDueDate").val();
    dueDate = new Date(dueDate);
    dueDate.setHours(0,0,0,0);
    let lstPriority = $("#lstPriority").val();

    let isValid = true;
    let err = $("#err");
    err.empty();
    let message = $("<ul>");
    if (!lstCat) {
      isValid = false;
      message.append("<li>You must select task category</li>");
    }
    console.log(dueDate);
    console.log(CurrentDate);
    if (dueDate < CurrentDate) {
      isValid = false;
      message.append("<li>You must select a valid date</li>");
    }
    if (!lstPriority) {
      isValid = false;
      message.append("<li>You must select Priority</li>");
    }

    if (!isValid) {
      event.preventDefault();
      err.append(message);
    }
  });
});