<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
</head>
<body style="font-family: Arial, Verdana, sans-serif; font-size: 14px; color: #333333; text-align: justify; margin: 0; padding: 0;" bgcolor="#dee2e6">
<table width="100%" bgcolor="#dee2e6" style="" cellpadding="0" cellspacing="0" border="0">
    <tbody>
    <tr>
        <td align="center">
            <table style="text-align: justify;" cellpadding="5" cellspacing="0" width="700" bgcolor="#ffffff" align="center">
                <tr>
                    <td>
                        <div style="margin-bottom: 20px;">
                            <img width="150" src="${logo_url}" alt="LOGO CNR">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p style="margin: 0;white-space:pre;">${text!''}</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="border-bottom-width: 1px; border-bottom-color: #dee2e6; border-bottom-style: solid; margin: 10px 0;">
                            <h2 style="color: #c8102e; margin: 5px 0 10px;">${layerName!'&nbsp;'}</h2>
                            <table width="100%" cellpadding="0" cellspacing="0">
                                <thead>
                                <tr>
                                    <th style="width: 18%; color: #fff; padding: 5px 8px; border: #454d55;" align="center" bgcolor="#343a40" valign="top"> </th>
                                    <#list attributes as attribute>
                                        <th style="width: 18%; color: #fff; padding: 5px 8px; border: #454d55;" align="center" bgcolor="#343a40" valign="top">${attribute}</th>
                                    </#list>
                                </tr>
                                </thead>
                                <tbody>
                                <#list features as feature>
                                    <tr>
                                        <td style="width: 18%; border-top-width: 1px; border-top-color: #dee2e6; border-top-style: solid; color: #c8102e; padding: 5px 8px;" valign="top">${feature.id!'&nbsp;'}</td>
                                        <#list attributes as attribute>
                                            <td style="width: 18%; border-top-width: 1px; border-top-color: #dee2e6; border-top-style: solid; padding: 5px 8px;" valign="top">${feature.properties[attribute]!'&nbsp;'}</td>
                                        </#list>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p style="font-size: 0.75rem; font-style: italic;">
                            Ceci est un mail automatique, merci de ne pas répondre.
                        </p>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
