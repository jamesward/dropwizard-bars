function loadBars() {
    $.get("/bars", function(data) {
        $("#bars").empty()
        $.each(data, function(i, bar) {
            $("#bars").append($("<li>").text("Bar: " + bar.name))
        })
    })
}

$(function() {
    $("body").append($("<ul>").attr("id", "bars"))

    var form = $("<form>").attr("id", "barForm")
    form.append($("<input>").attr("id", "barName").attr("name", "name"))
    form.append($("<input>").attr("type", "submit"))
    $("body").append(form)

    $("#barForm").bind("submit", function(event) {
        event.preventDefault()
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: "bars",
            data: JSON.stringify({name: $("#barName").val()}),
            dataType: 'json',
            success: loadBars
        })
        $("#barName").val("")
    })

    loadBars()
})