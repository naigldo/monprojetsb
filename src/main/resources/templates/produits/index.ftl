<#import "/spring.ftl" as spring/>

<head>
    <#include "../includable/bootstrap.ftl">
</head>
<body>
    <a href="create">Create Product</a>
    <br>
    <hr/>

    <#if page??>
    <h1> ${page} </h1>
    </#if>

    <table class="table">
        <tr>
        <th>Name</th>
        <th>Price</th>
        </tr>

        <#if items??>
            <#list items as item>
                <tr>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><a href="show/${item["id"]}">Show</a></td>
                    <td>
                        <form action="delete" method="POST">
                        <input type="hidden" name="id" value="${item["id"]}">
                        <input type="submit" value="delete"/>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
</body>
