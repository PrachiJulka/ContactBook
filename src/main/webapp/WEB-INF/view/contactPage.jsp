<%--
  Created by IntelliJ IDEA.
  User: prachi
  Date: 7/2/18
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: prachi
  Date: 7/2/18
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.5/css/select.bootstrap.min.css">
    <link rel="stylesheet" href="../../extensions/Editor/css/editor.bootstrap.min.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<div class="container" style="
    background-color: darkslateblue;
    color: white;
    font-size: 27px;">
    <div class="col-lg-4">
        CONTACT BOOK
    </div>
    <div class=col-lg-4"></div>
    <div class=col-lg-4">Uday pratap singh</div>

</div>
<br/>
<div class="container">
    <div class="col-lg-2">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#contactModal">Add user</button>
    </div>
<div class="col-lg-2">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#categoryModal">Add Category</button>
</div>

    <div class="col-lg-4">
        <input type="text"/>
    </div>
    <div class="col-lg-4">
        <select>

            <option value="volvo">Select Category</option>
            <option value="volvo">Volvo</option>
            <option value="saab">Saab</option>
            <option value="mercedes">Mercedes</option>
            <option value="audi">Audi</option>
        </select>
    </div>
</div>
<br/>
<div class="container">
    <div class="col-lg-12">
    <table id="example" class="table table-striped table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone #</th>
            <th>Company</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a class="fa fa-pencil-square-o" aria-hidden="true">
                </a>
                <a class="fa fa-trash" aria-hidden="true">
                </a></td>
        </tr>
    </table>
    </div>
</div>
<!-- Modal Add User-->

<div class="modal fade" id="contactModal" role="dialog">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add Contact</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone">
                </div>
                <div class="form-group">
                    <label for="company">Company:</label>
                    <input type="text" class="form-control" id="company">
                </div>

                <div class="form-group">
                    <label for="category">Category:</label>
                    <input type="text" class="form-control" id="category">
                </div>
            </div>
            <div class="form-group">
                <<input type="button" class="btn btn-default" id="addCont" data-dismiss="modal" value="Add"></input>
                <input type="button" class="btn btn-default" data-dismiss="modal">Close</input>
            </div>
        </div>
    </div>
</div>


<!-- Modal Add Category-->

<div class="modal fade" id="categoryModal" role="dialog">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add Category</h4>
            </div>
            <div class="modal-body">
               <input type="text" style="width:500px"/>
                <a class="fa fa-pencil-square-o" style="background-color: #1CA347" aria-hidden="true">
                </a>
                <a class="fa fa-trash" aria-hidden="true" style="background-color: red"></a>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="addCategory" data-dismiss="modal">Add</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>


<spring:url value="resources/js/contectPage.js" var="contectPageJs" />
<script src="${contectPageJs}"></script>

</body>
</html>


