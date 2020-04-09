<#import "/spring.ftl" as spring/>

<head>

<#include "../includable/bootstrap.ftl">

</head>

<body>

<H1>User Create</H1>


<form action="<@spring.url '/users/create'/>" method="POST">

Firstname:<br>

<input type="text" name="name" value="">

<br>

Lastname:<br>

<input type="text" name="price" value="">

<br><br>


<input type="submit" value="Submit">

</form>

</body>