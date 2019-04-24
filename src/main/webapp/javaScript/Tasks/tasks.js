$(function () {
  $(".deleteBtn").click(function (event) {
    let retVal = confirm("Do you want to continue ?");
    if(retVal) {
      let taskId = $(this).attr("data-id");
      let url = window.location.href;
      let parentTr = $(this).parents("tr");

      $.ajax({
        url : url + "?TaskId=" + taskId,
        type:"Delete",
        success:function (data) {
          if(data === true){
            parentTr.remove();
          }
        }
      });
    }
  });

  $(".completeBtn").click(function (event) {
    let retVal = confirm("Do you want to continue ?");
    if(retVal) {
      let taskId = $(this).attr("data-id");
      let url = window.location.href;

      let self = $(this);

      $.ajax({
        url : url + "?TaskId=" + taskId,
        type:"Put",
        success:function (data) {
          if(data.updated === "true"){

            $("input[name=" + taskId+ "]").attr("checked", true);

            self.parents("tr").find(".updateElement").remove();
            self.parents("tr").find(".deleteBtn").remove();
            self.remove();
          }
        }
      });

    }
  });
});