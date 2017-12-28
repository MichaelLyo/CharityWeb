function showFollowProjects(){
    $("#learning-tab").click(
        function () {
            $("#hiddenForm").attr("action","showFollowProjects");
            $("#hiddenForm").attr("method","get");
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


function showDonate(){
    $("#painting-tab").click(
        function () {
            $("#hiddenForm").attr("action","mgtDonate");
            $("#userName").val($("#userNameShow").text());
            $("#hiddenForm").submit();
        }
    )
}

