function getRepDescription(obj) {
    var id = obj.id.toString();
    var descriptionId = "description"+id;

    var obj = document.getElementById(descriptionId);
    var modal =document.getElementById("modal-content");
    modal.innerText = obj.innerText;
    console.log(modal.innerText);
}


function getProjects(obj) {
    var repName = obj.innerText;
    $("#repName").val(repName);
    $("#userName").val($("#userNameShow").text());
    $("#hiddenForm").submit();
}