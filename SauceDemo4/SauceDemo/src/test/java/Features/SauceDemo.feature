@Login
  Feature: Login Test

    @AmazonLoginSuccessAndSale
    Scenario Outline: Success Login Proccess
      Given User at HomePage "<website>"
      And Except Cookies "<cookieAccept>" "<cookieReject>"
      And Click login button "<loginButton>"
      And write Correct "<usernameElement>" and "<username>" for username field
      And Click login button "<nextButton>"
      And write false "<passwordElement>" and "<password>" for password field
      And Click login button "<controlButton>"
      And Select Input Button "<selectInputButtonPath>" "<inputMessage>" and Click Search Button "<searchButtonPath>"
      And Click Shipped by Amazon
      And Choose Apple "<chooseButtonPath>"
      And Click to Product "<productPath>"
      And Add "<addToCartButtonPath>" and Go to Cart "<goToCartButtonPath>"
      And Complete Cart "<completeCartButtonPath>"
      And Fill "//input[@id='address-ui-widgets-enterAddressFullName']" the Name and Surname "Mehmet Kara"
      And Fill "<telephoneNumberPath>" the Telephone Number "<telephoneNumber>"
      And Fill the Address
      And Fill the City, District, Neighbourhood

#      And Click login button "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']"
      Examples:
      | website                    | cookieAccept                | cookieReject                    | loginButton                                   | usernameElement         | username                     | nextButton              | passwordElement            | password   | controlButton               | selectInputButtonPath             |inputMessage|searchButtonPath                        |chooseButtonPath                                              | productPath                                                                 |   addToCartButtonPath             | goToCartButtonPath           | completeCartButtonPath                   | telephoneNumberPath                                       | telephoneNumber |
      | https://www.amazon.com.tr/ | //input[@id='sp-cc-accept'] | //a[@id='sp-cc-rejectall-link'] | //span[@id='nav-link-accountList-nav-line-1'] | //input[@id='ap_email'] | testautomationexam@gmail.com | //input[@id='continue'] | //input[@id='ap_password'] | Mehmet1234 | //input[@id='signInSubmit'] | //input[@id='twotabsearchtextbox']| airpods    | //input[@id='nav-search-submit-button']|//li[@id='p_89/Apple']//i[@class='a-icon a-icon-checkbox']    |//img[@src='https://m.media-amazon.com/images/I/61p2QS1squL._AC_UL400_.jpg'] |//input[@name='submit.add-to-cart']|//a[@href='/cart?ref_=sw_gtc']| //input[@name='proceedToRetailCheckout'] | //input[@id='address-ui-widgets-enterAddressPhoneNumber'] |  543 987 6543   |

    @AmazonLoginFail
    Scenario Outline: Fail Login Proccess
      Given User at HomePage "<website>"
      And Except Cookies "<cookieAccept>" "<cookieReject>"
      And Click login button "<loginButton>"
      And write Correct "<usernameElement>" and "<username>" for username field
      And Click login button "<nextButton>"
      And write false "<passwordElement>" and "<password>" for password field
      When Click login button "<controlButton>"
      Then Check "<error>" error message
      Examples:
        | website                    | cookieAccept                | cookieReject                    | loginButton                                   | usernameElement         | username                     | nextButton              | passwordElement            | password   |controlButton                |error                                     |
        | https://www.amazon.com.tr/ | //input[@id='sp-cc-accept'] | //a[@id='sp-cc-rejectall-link'] | //span[@id='nav-link-accountList-nav-line-1'] | //input[@id='ap_email'] | testautomationexam@gmail.com | //input[@id='continue'] | //input[@id='ap_password'] | Mehmet1 | //input[@id='signInSubmit'] |//h4[contains(text(),'Bir sorun oluştu')] |


    @TrendyolLoginSuccessAndSale
    Scenario Outline: Success Login Proccess
      Given User at HomePage "<website>"
      And Except Cookies "<cookieAccept>" "<cookieReject>"
      And Click login button "<loginButton>"
      And write Correct "<usernameElement>" and "<username>" for username field
      And write false "<passwordElement>" and "<password>" for password field
      And Click login button "<controlButton>"
      And Select Input Button "<selectInputButtonPath>" "<inputMessage>" and Click Search Button "<searchButtonPath>"
      And Choose Apple "<chooseButtonPath>"
      And Click to Product "<productPath>"
      And Add "<addToCartButtonPath>" and Go to the Cart "<goToCartButtonPath>"
      And Click to Understand Button
      And Empty the Basket "<deleteButtonPath>"

      Examples:
        | website                   |cookieAccept                                | cookieReject               | loginButton                       | usernameElement            | username                    | passwordElement                    |password   | controlButton                                                |selectInputButtonPath                                                   |inputMessage|searchButtonPath        |chooseButtonPath                 | productPath                                                                        |   addToCartButtonPath                     | goToCartButtonPath               |deleteButtonPath|
        | https://www.trendyol.com/ |//button[@id='onetrust-accept-btn-handler'] | //a[@id='rejectAllButton'] | //p[contains(text(),'Giriş Yap')] | //input[@id='login-email'] | testautomationexam@gmail.com| //input[@id='login-password-input']|Mehmet1234 | //button[@type='submit']//span[contains(text(),'Giriş Yap')] | //input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız'] | airpods    | //i[@class='cyrzo7gC'] | //div[contains(text(),'Apple')] | //a[@href='/apple/airpods-2-nesil-beyaz-bluetooth-kulaklik-mv7n2tu-a-apple-turkiye-garantili-p-6405631?boutiqueId=619598&merchantId=968'] | //div[@class='add-to-basket-button-text'] | //a[@class='go-basket-button'] | //i[@class='i-trash'] |

    @TrendyolLoginFail
    Scenario Outline: Fail Login Proccess
      Given User at HomePage "<website>"
      And Except Cookies "<cookieAccept>" "<cookieReject>"
      And Click login button "<loginButton>"
      And write Correct "<usernameElement>" and "<username>" for username field
      And write false "<passwordElement>" and "<password>" for password field
      When Click login button "<controlButton>"
      Then Check "<error>" error message
      Examples:
        | website                   | cookieAccept                               | cookieReject               | loginButton                       | usernameElement            | username                     | passwordElement                    | password  | controlButton                                                | error                    |
        | https://www.trendyol.com/ |//button[@id='onetrust-accept-btn-handler'] | //a[@id='rejectAllButton'] | //p[contains(text(),'Giriş Yap')] | //input[@id='login-email'] | testautomationexam@gmail.com | //input[@id='login-password-input']| Mehmet123 | //button[@type='submit']//span[contains(text(),'Giriş Yap')] | //span[@class='message'] |

#    @HepsiBuradaLoginSuccess
#    Scenario Outline: Success Login Proccess
#      Given User at HomePage "<website>"
#      And Except Cookies "<cookieAccept>" "<cookieReject>"
#      And Click login Hover button "<loginHoverButton>"
#      And Click login button "<loginButton>"
#      And write Correct "<usernameElement>" and "<username>" for username field
#      And Click login button "<nextButton>"
#      And write false "<passwordElement>" and "<password>" for password field
#      When Click login button "<controlButton>"
#      Examples:
#        | website                      | cookieAccept                                | cookieReject                                             | loginHoverButton           | loginButton    | usernameElement            | username                     | nextButton               | passwordElement            | password   | controlButton                 |
#        | https://www.hepsiburada.com/ | //button[@id='onetrust-accept-btn-handler'] | //a[@aria-label='Gizliliğiniz hakkında daha fazla bilgi']| //span[@title='Giriş Yap'] |//a[@id='login']| //input[@id='txtUserName'] | testautomationexam@gmail.com | //button[@id='btnLogin'] | //input[@id='txtPassword'] | Mehmet1234 | //button[@id='btnEmailSelect']|

#    @HepsiBuradaLoginFail
#    Scenario Outline: Fail Login Proccess
#      Given User at HomePage "<website>"
#      And Except Cookies "<cookieAccept>" "<cookieReject>"
#      And Click login Hover button "<loginHoverButton>"
#      And Click login button "<loginButton>"
#      And write Correct "<usernameElement>" and "<username>" for username field
#      And Click login button "<nextButton>"
#      And write false "<passwordElement>" and "<password>" for password field
#      When Click login button "<controlButton>"
#      Then Check "<error>" error message
#      Examples:
#        | website                      | cookieAccept                                | cookieReject                                             | loginHoverButton           | loginButton     | usernameElement            | username                     | nextButton               | passwordElement            | password |controlButton                   | error                                                         |
#        | https://www.hepsiburada.com/ | //button[@id='onetrust-accept-btn-handler'] | //a[@aria-label='Gizliliğiniz hakkında daha fazla bilgi']| //span[@title='Giriş Yap'] | //a[@id='login']| //input[@id='txtUserName'] | testautomationexam@gmail.com | //button[@id='btnLogin'] | //input[@id='txtPassword'] | Mehmet123| //button[@id='btnEmailSelect'] | /html/body/div[1]/div/div/div[1]/div[2]/div/div/div[4]/div/div|
