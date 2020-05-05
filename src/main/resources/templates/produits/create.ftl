<#import "/spring.ftl" as spring/>

<head>
	<#include "../includable/bootstrap.ftl">
</head>

<body>
    <a href="index">List of product</a>
    <br>
    <hr/>
    <h1>Create product</h1>

    <form action="<@spring.url '/product/create'/>" method="POST">
        Name : <input type="text" name="name" value="">
        <br>
        <br>
        Price : <input type="text" name="price" value="">
        <br>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
