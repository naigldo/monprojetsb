<#import "/spring.ftl" as spring/>

<head>
    <#include "../includable/bootstrap.ftl">
</head>
<body>
	<a href="../index">List of product</a>
	<br>
	<hr/>
    <h1>Details of a product</h1>
    <br>
    <p>Product id - ${product.id}</p>
    <br>
    <p>Product name - ${product.name}</p>
    <br>
    <p>Product price - ${product.price}</p>
</body>
