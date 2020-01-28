<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
</head>
<body style="font-family: Arial, Verdana, sans-serif; font-size: 14px; text-align: justify; margin: 0; padding: 0;" bgcolor="#dee2e6">
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
                        <div style="padding-bottom: 10px; border-bottom-width: 1px; border-bottom-color: #dee2e6; border-bottom-style: solid; margin: 10px 0;">
                            <h2 style="color: #c8102e; margin: 5px 0 10px;">${layerName!'&nbsp;'}</h2>
                            <div>
                                <#list features as feature>
                                    <div>
                                        <h3 style="color: #c8102e; padding-top: 8px; border-top-width: 1px; border-top-color: #dee2e6; border-top-style: solid; margin: 5px 0;">${feature.id!'&nbsp;'}</h3>
                                        <#list attributes as attribute>
                                            <div style="display: block; vertical-align: top; width: 100%; margin: 10px 0;">
                                                <span style="font-weight: 600;">${attribute}</span>: ${feature.properties[attribute]!'&nbsp;'}
                                            </div>
                                        </#list>
                                    </div>
                                </#list>
                            </div>
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