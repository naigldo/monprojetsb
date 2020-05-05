<#import "/spring.ftl" as spring/>

<head>
    <#include "../includable/bootstrap.ftl">
</head>

<body>
	<a href="index">List of user</a>
	<br>
    <hr/>
    <h1>Create user</h1>

    <form action="<@spring.url '/user/create'/>" method="POST">
        Firstname : <input type="text" name="firstname" value="">
        <br>
        <br>
        Lastname : <input type="text" name="lastname" value="">
        <br>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
