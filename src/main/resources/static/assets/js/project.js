function buttonSubmit(obj){
    var type = obj.id.toString();
    if(type == "search"){
        $("#searchAndNew").attr("action","searchProject");
        $("#repName").val($("#repNameShow").text());
        console.log($("#repNameShow").text());
        $("#searchAndNew").attr("method","post");
        $("#search").submit();

    }
    else {
        $("#searchAndNew").attr("method","post");
        $("#new").submit();
    }
}


function projectSubmmit(obj){

    $("#project-form").submit();

    console.log("here");
}