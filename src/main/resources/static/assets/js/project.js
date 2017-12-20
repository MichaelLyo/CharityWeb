function buttonSubmit(obj){
    var type = obj.id.toString();
    console.log(type);
    if(type == "search"){
        $("#searchAndNew").attr("action","searchProject");
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