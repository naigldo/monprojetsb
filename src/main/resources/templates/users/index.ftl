<#import "/spring.ftl" as spring/>

<head>
    <#include "../includable/bootstrap.ftl">
</head>
<body>
    <a href="create">Create user</a>
    <br>
    <hr/>

    <#if page??>
    <h1> ${page} </h1>
    </#if>
    <table class="table">
        <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        </tr>

        <#if items??>
            <#list items as item>
                <tr>
                    <td>${item.firstname}</td>
                    <td>${item.lastname}</td>
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
