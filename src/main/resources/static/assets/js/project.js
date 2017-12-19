function buttonSubmit(obj){
    var type = obj.id.toString();
    console.log(type);
    if(type == "search"){
        $("#searchAndNew").attr("action","showProjects");
        $("#searchAndNew").attr("method","post");
        $("#search").submit();

    }
    else {
        $("#searchAndNew").attr("action","createProject");
        $("#searchAndNew").attr("method","get");
        $("#new").submit();
    }
}