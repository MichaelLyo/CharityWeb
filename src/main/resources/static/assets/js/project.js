//搜素和新建框
// function buttonSubmit(obj){
//     var type = obj.id.toString();
//     if(type == "search"){
//         $("#searchAndNew").attr("action","searchProject");
//         $("#repName").val($("#repNameShow").text());
//         $("#searchAndNew").attr("method","post");
//         $("#search").submit();
//
//     }
//     else {
//         $("#searchAndNew").attr("method","post");
//         $("#repName").val($("#repNameShow").value());
//         $("#new").submit();
//     }
// }


function projectSubmmit(obj){
    $("#project-form").submit();
}
function showProjectDetail(obj){
    $("#searchAndNew").attr("action","searchProject");
    $("#projName").val($(obj).text());
    $("#searchAndNew").submit();
}

function replaceProjects(data){
    var projectLi = $("#project-list").first();
    var projName = data.projName;
    var followerNum = data.followerNum;
    var participateNum = data.participateNum;
    var context = data.context;
    var endDate =data.endDate;
    $("#projectUl").empty();
    projectLi.find("h3.project-name-h3").text(projName);
    projectLi.find("#followerNum").text(followerNum);
    projectLi.find("#participateNum").text(participateNum);
    projectLi.find(".project-description").text(context);
    projectLi.find(".create-date-li").text(endDate);
    $("#projectUl").append(
    "<li class='repository-div' id='project-list' "+projectLi.html()+
        "</li>"
    );
    $("a#projectSrc").click(
        function () {
            console.log("shit");
            $("#searchAndNew").attr("action","showProjectDetail");
            $("#searchAndNew").attr("method","post");
            $("#repName").val($("#repNameShow").text());
            $("#projName").val($(this).children(":first").text());
            $("#searchAndNew").submit();
            console.log("shit");
        }
    );
}

function replaceProjects(data){
    var projectLi = $("#project-list").first();
    var projName = data.projName;
    var followerNum = data.followerNum;
    var participateNum = data.participateNum;
    var context = data.context;
    var endDate =data.endDate;
    $("#projectUl").empty();
    projectLi.find("h3.project-name-h3").text(projName);
    projectLi.find("#followerNum").text(followerNum);
    projectLi.find("#participateNum").text(participateNum);
    projectLi.find(".project-description").text(context);
    projectLi.find(".create-date-li").text(endDate);
    $("#projectUl").append(
        "<li class='repository-div' id='project-list' "+projectLi.html()+
        "</li>"
    );
    $("a#projectSrc").click(
        function () {
            console.log("shit");
            $("#searchAndNew").attr("action","showProjectDetail");
            $("#searchAndNew").attr("method","post");
            $("#repName").val($("#repNameShow").text());
            $("#projName").val($(this).children(":first").text());
            $("#searchAndNew").submit();
            console.log("shit");
        }
    );
}


function searchProjectWithAjax() {
    var repName = $("#repName").val($("#repNameShow").text()).val();
    var projName = $("#projName").val();
    var userName = $("#userName").val();

    console.log(userName);
    console.log(repName);
    console.log(projName);

    $.ajax({
        async: true,
        type: "POST",
        url: "http://localhost:9090/spring-boot/testAjax",//注意路径
        data: "repName="+repName+"&userName="+userName+"&projName="+projName,
        dataType: "json",
        success: function (response) {
            replaceProjects(response);
        },
        error: function (response) {
            alert(response.data);
        }

    });
}
function searchProjectWithAjax2() {
    var project = $("#projectSrc").first();
    console.log(project.find("input[name='repName']").first().val());
    console.log(project.find("input[name='userName']").first().val());
    var repName = $("#repName").val(project.find("input[name='repName']").first().val()).val();
    var projName = $("#projName").val();
    var userName = $("#userName").val(project.find("input[name='userName']").first().val()).val();

    console.log(userName);
    console.log(repName);
    console.log(projName);

    $.ajax({
        async: true,
        type: "POST",
        url: "http://localhost:9090/spring-boot/followerProjects",//注意路径
        data: "repName="+repName+"&userName="+userName+"&projName="+projName,
        dataType: "json",
        success: function (response) {
            replaceProjects(response);
        },
        error: function (response) {
            alert(response.data);
        }

    });
}

function projectDetail(obj){
    var project = $(obj);
    var modal = $("#myModal");
    var projName = project.parent().prev().text().trim();
    var repName = $("#repNameShow").text().trim();
    var content = project.text().trim();

    var ul = project.parent().next();
    var followerNum = ul.find("#followerNum").first().text().trim();
    var participateNum = ul.find("#participateNum").first().text().trim();
    var startDate = ul.find("#startDate").first().text().trim();
    var endDate = ul.find("#endDate").first().text().trim();

    modal.find("#modalRepName").first().text(projName);
    modal.find("#modalFollowerNum").first().text(followerNum);
    modal.find("#modalParticipateNum").first().text(participateNum);
    modal.find("#modalStartDate").first().text(startDate.substr(12));
    modal.find("#modalEndDate").first().text(endDate.substr(8));
    modal.find("#myModalLabel").first().text(projName);
    modal.find("#modalContext").first().text(content);

}