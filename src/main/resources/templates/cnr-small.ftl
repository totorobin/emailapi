<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
</head>
<body style="font-family: Arial, Verdana, sans-serif; font-size: 12px; color: #333333; text-align: justify; margin: 0; padding: 0;" bgcolor="#dee2e6">
<table width="100%" bgcolor="#dee2e6" style="" cellpadding="0" cellspacing="0" border="0">
    <tbody>
    <tr>
        <td align="center">
            <table style="text-align: justify;" cellpadding="5" cellspacing="0" width="700" bgcolor="#ffffff" align="center">
                <tr>
                    <td>
                        <div style="margin-bottom: 20px;text-align: right;">
                            <img width="100" src="${logo_url}" alt="LOGO CNR">
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
                            <table width="100%" cellpadding="0" cellspacing="0">
                                <thead>
                                <tr>
                                    <#list attributes as attribute>
                                        <th style="color: #fff; padding: 5px 8px; border: #454d55;" align="center" bgcolor="#343a40" valign="top">${attribute}</th>
                                    </#list>
                                </tr>
                                </thead>
                                <tbody>
                                <#list features as feature>
                                    <tr>
                                        <#list attributes as attribute>
                                            <td style="border-top-width: 1px; border-top-color: #dee2e6; border-top-style: solid; padding: 5px 8px;font-size: 11px;" valign="top">${feature.properties[attribute]!'&nbsp;'}</td>
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
                        <p style="font-size: 9px; font-style: italic;">
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
