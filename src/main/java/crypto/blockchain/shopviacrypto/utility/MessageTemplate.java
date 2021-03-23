package crypto.blockchain.shopviacrypto.utility;

public class MessageTemplate {

	static String CreateAccountMessage(String message) {
		return "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\r\n" + 
				"<html xmlns='http://www.w3.org/1999/xhtml'>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\r\n" + 
				"    <meta name='format-detection' content='telephone=no' />\r\n" + 
				"    <meta name='viewport' content='width=device-width,initial-scale=1.0' />\r\n" + 
				"    <title></title>\r\n" + 
				"    <style type='text/css'>\r\n" + 
				"        body {\r\n" + 
				"            margin: 0;\r\n" + 
				"            padding: 0;\r\n" + 
				"        }\r\n" + 
				"        /**This is to overwrite Outlook.com’s Embedded CSS************/\r\n" + 
				"        \r\n" + 
				"        body,\r\n" + 
				"        table,\r\n" + 
				"        td,\r\n" + 
				"        p,\r\n" + 
				"        a,\r\n" + 
				"        li,\r\n" + 
				"        blockquote {\r\n" + 
				"            -webkit-text-size-adjust: 100%;\r\n" + 
				"            -ms-text-size-adjust: 100%;\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        table,\r\n" + 
				"        td {\r\n" + 
				"            border-collapse: collapse;\r\n" + 
				"            mso-table-lspace: 0pt;\r\n" + 
				"            mso-table-rspace: 0pt;\r\n" + 
				"            border-spacing: 0;\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        img {\r\n" + 
				"            -ms-interpolation-mode: bicubic;\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        a,\r\n" + 
				"        a:link,\r\n" + 
				"        a:visited {\r\n" + 
				"            text-decoration: none;\r\n" + 
				"            color: #00788a\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        a:hover {\r\n" + 
				"            text-decoration: underline;\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        h2,\r\n" + 
				"        h2 a,\r\n" + 
				"        h2 a:visited,\r\n" + 
				"        h3,\r\n" + 
				"        h3 a,\r\n" + 
				"        h3 a:visited,\r\n" + 
				"        h4,\r\n" + 
				"        h5,\r\n" + 
				"        h6,\r\n" + 
				"        .t_cht {\r\n" + 
				"            color: #000 !important\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        p {\r\n" + 
				"            margin-bottom: 0\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        .ExternalClass p,\r\n" + 
				"        .ExternalClass span,\r\n" + 
				"        .ExternalClass font,\r\n" + 
				"        .ExternalClass td {\r\n" + 
				"            line-height: 100%\r\n" + 
				"        }\r\n" + 
				"        /**This is to center your email in Outlook.com************/\r\n" + 
				"        \r\n" + 
				"        .ExternalClass {\r\n" + 
				"            width: 100%;\r\n" + 
				"        }\r\n" + 
				"        /*MOBILE STLYE*/\r\n" + 
				"        \r\n" + 
				"        @media only screen and (max-width: 480px) {\r\n" + 
				"            body {\r\n" + 
				"                width: 100% !important;\r\n" + 
				"                min-width: 100% !important;\r\n" + 
				"            }\r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            /*clear and remove*/\r\n" + 
				"            .show-img2 {\r\n" + 
				"                display: block !important;\r\n" + 
				"            }\r\n" + 
				"            .show-img2 img {\r\n" + 
				"                width: 50% !important;\r\n" + 
				"                height: auto !important;\r\n" + 
				"            }\r\n" + 
				"            td[class~='a1'] {\r\n" + 
				"                font-size: 16px !important;\r\n" + 
				"                line-height: 24px !important;\r\n" + 
				"            }\r\n" + 
				"            td[class~='b1'] {\r\n" + 
				"                border-bottom: 1px #d8d7d7 solid !important;\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align='center' valign='middle'>\r\n" + 
				"                <table class='p-t' style='background: #fff;' width='700' border='0' cellspacing='0' cellpadding='0' align='center'>\r\n" + 
				"                    \r\n" + 
				"                    <tr>\r\n" + 
				"                        <td style='padding: 10px 0px;' align='center'>\r\n" + 
				"                            <table width='96%' border='0' cellspacing='0' cellpadding='0' align='center'>\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td>\r\n" + 
				"                                        <table class='p-100' border='0' cellspacing='0' cellpadding='0' align='left'>\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td align='center'>\r\n" + 
				"                                                    <a title='Link 3' href='http://shopviacrypto.com/' target='email'><img style='vertical-align: middle; border: none 0;' src='assets/img/logo.png'\r\n" + 
				"                                                            alt='shopviacrypto.com' width='245' height='60' /></a>\r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td style='height: 20px; font-size: 0; line-height: 0; overflow: hidden;'></td>\r\n" + 
				"                    </tr>\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td class='p-i'><img style='vertical-align: middle; border: none 0;' src='assets/img/banner.gif' alt='Thanks for signing up!'\r\n" + 
				"                                width='700' height='285' /></td>\r\n" + 
				"                    </tr>\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td align='center' bgcolor='#FF9000' height='20'>\r\n" + 
				"                            <table class='p-90' width='70%' border='0' cellspacing='0' cellpadding='0' align='center'>\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td style='font-family: Microsoft YaHei, arial, sans-serif; mso-line-height-rule: exactly; font-size: 16px; line-height: 22px; font-weight: bold; color: #fff;'\r\n" + 
				"                                        align='center' bgcolor='#FF9000' height='20'>There&acute;s only one more step, please click on &#8220;Conform Now&#8221; to confirm your shopviacrypto\r\n" + 
				"                                        account, and to stay up-to-date on all your orders, shipping status, and more. <br\r\n" + 
				"                                        /> </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td style='padding-top: 15px; padding-bottom: 15px;' align='center' bgcolor='#FF9000' height='20'>\r\n" + 
				"                            <a title='Confirmation Link' href='"+message+"' target='email'><img style='vertical-align: middle; border: none 0;' src='assets/img/confirmButton.png' alt='Confirm Email'\r\n" + 
				"                                    width='135' height='30' /></a>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                </table>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>\r\n" + 
				"";
	}
}
