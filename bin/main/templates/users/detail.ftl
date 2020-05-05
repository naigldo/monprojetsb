<#import "/spring.ftl" as spring/>

<head>
    <#include "../includable/bootstrap.ftl">
</head>
<body>
	<a href="../index">List of product</a>
	<br>
	<hr/>
    <h1>Details of a user</h1>
    <br>
    <p>User id - ${user.id}</p>
    <br>
    <p>User firstname - ${user.firstname}</p>
    <br>
    <p>User lastname - ${user.lastname}</p>

    <h4>Products of this user: </h4>
    <table class="table">
        <tr>
        <th>Name</th>
        <th>Price</th>
        </tr>

        <#list items as item>
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
            </tr>
        </#list>
    </table>
</body>
