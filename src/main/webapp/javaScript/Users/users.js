$(function () {
    $(".deleteBtn").click(function (event) {
        event.preventDefault();
        let retVal = confirm("Do you want to continue ?");
        if(retVal){
            let userId=$(this).attr("data-id");
            let url=window.location.href;
            let parentTr=$(this).parents("tr");
            $.ajax({
                url:url+"?UserID="+userId,
                type:"Delete",
                success:function (data) {
                    if(data===true){
                        parentTr.remove();
                    }
                }
            });

        }

    });
});