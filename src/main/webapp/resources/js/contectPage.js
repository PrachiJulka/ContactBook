// use a global for the submit and return data rendering in the examples

/* $(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
        ajax: "../php/staff.php",
        table: "#example",
        fields: [ {
            label: "First name:",
            name: "first_name"
        }, {
            label: "Last name:",
            name: "last_name"
        }, {
            label: "Position:",
            name: "position"
        }, {
            label: "Office:",
            name: "office"
        }, {
            label: "Extension:",
            name: "extn"
        }, {
            label: "Start date:",
            name: "start_date",
            type: 'datetime'
        }, {
            label: "Salary:",
            name: "salary"
        }
        ]
    } );

    var table = $('#example').DataTable( {
        lengthChange: false,
        ajax: "../php/staff.php",
        columns: [
            { data: null, render: function ( data, type, row ) {
                    // Combine the first and last names into a single table field
                    return data.first_name+' '+data.last_name;
                } },
            { data: "position" },
            { data: "office" },
            { data: "extn" },
            { data: "start_date" },
            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
        ],
        select: true
    } );

    // Display the buttons
    new $.fn.dataTable.Buttons( table, [
        { extend: "create", editor: editor },
        { extend: "edit",   editor: editor },
        { extend: "remove", editor: editor }
    ] );

    table.buttons().container()
        .appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );
} );

*/

$(document).ready(function(){

    $("#addCont").click(function(e){

        var name=$('#name').val();
        var email=$('#email').val();
        var phone=$('#phone').val();
        var company=$('#company').val();
        var category=$('#category').val();

        alert("hello"+name);

        $.ajax({
            type:"POST",
            url:"/addContact",

        data: "name=" + name + "&email=" + email +"&phone="+ phone + "&company=" + company ,

            success: function (response) {
                // we have the response
                alert("Contact Added Successfully");
                $('#contactModal').modal('hide');
            },
            error: function (e) {
                //  console.log( " xhr.responseText: " + xhr.responseText + " //status: " + status + " //Error: "+error );
                alert("ERROR");
                $('#contactModal').modal('hide');
            }
        });


    });

/*

    $("#addCategory").click(function(e){

        var name=$('#name').val();
        var visibility=$('#visibility').val();
        $.ajax({
            type: "POST",
            url: "/addCategory",

            data: "name=" + name + "&visibility=" + visibility,
            success: function (response) {
                // we have the response
                alert("Topic Inserted Successfully");
                $('#categoryModal').modal('hide');
            },
            error: function (e) {
                //  console.log( " xhr.responseText: " + xhr.responseText + " //status: " + status + " //Error: "+error );
                alert("ERROR");
                $('#categoryModal ').modal('hide');
            }
        });


    });
*/
});



