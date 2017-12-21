function showFollowProjects(){
    $("#learning-tab").click(
        function () {
            $("#hiddenForm").attr("action","showFollowProjects");
            $("#userName").val($("#userNameShow").text());
            $("#hiddenForm").submit();
        }
    )
};

function showParProjects (){
    $("#playing-tab").click(
        function () {
            $("#hiddenForm").attr("action","showParProjects");
            $("#userName").val($("#userNameShow").text());
            $("#hiddenForm").submit();
        }
    )
};

