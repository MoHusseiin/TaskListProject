$(function () {
    $(".deleteBtn").click(function (event) {
        let retVal = confirm("Do you want to continue ?");
        if(retVal)
        {
            let teamId=$(this).attr("data-id");
            let url=window.location.href;
            let parentTr=$(this).parents("tr");
            $.ajax({
                url:url+"?teamId="+teamId,
                type:"Delete",
                success:function (data) {
                    if(data===true){
                        parentTr.remove();
                    }
                }
            });

        }
        else
        {
            event.preventDefault();
        }
    });


});