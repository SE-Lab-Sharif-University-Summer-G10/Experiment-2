# software-engineering-lab Experiment 2

<div dir='rtl'>

## گام اول
| ردیف | محل اعمال تغییرات    | عنوان تغییر                  | شرحی کوتاه از تغییر                               |
|------|----------------------|------------------------------|---------------------------------------------------|
| ۱    | Order Service        | افزودن تابع پردات تلفنی      | افزودن یک تابع void با عنوان phone Order Payment  |
| ۲    | Order Service        | افزودن تابع ثبت سفارش تلفنی  | افزودن یک تابع void با عنوان phone Order Register |
| ۳    | Phone Order Service  | پیاده‌سازی دو تابع جدید      | پیاده‌سازی دو تابع جدید به صورت چاپ ساده          |
| ۴    | Phone Order Service  | پیاده‌سازی چهار تابع پیشین   | پیاده‌سازی چهار تابع پیشین به صورت بدنه خالی      |
| ۵    | OnSite Order Service | پیاده‌سازی دو تابع جدید      | پیاده‌سازی دو تابع جدید به صورت بدنه خالی         |
| ۶    | Online Order Service | پیاده‌سازی دو تابع جدید      | پیاده‌سازی دو تابع جدید به صورت بدنه خالی         |
| ۷    | Main                 | افزودن امکان پرداخت تلفنی    | افزودن شرط جدید برای امکان پرداخت تلفنی           |
| ۸    | Main                 | افزودن امکان ثبت سفارش تلفنی | افزودن شرط جدید برای امکان ثبت سفارش تلفنی        |
**مجموع تعداد تغییرات**: ۸

<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
.tg .tg-dvpl{border-color:inherit;text-align:right;vertical-align:top}
</style>
<table class="tg"><thead>
  <tr>
    <th class="tg-0pky">اصل مربوطه</th>
    <th class="tg-dvpl">علت نقض</th>
    <th class="tg-0pky">راه حل پیشنهادی</th>
  </tr></thead>
<tbody>
  <tr>
    <td class="tg-0pky">Single Responsibility Principle</td>
    <td class="tg-0pky">واسطی که برای OrderService نوشته شده است توانایی انجام هر دو کار ثبت و پرداخت سفارش را دارد که این عملا نقض‌کننده‌ی SRP است.</td>
    <td class="tg-0pky">ساخت دو واسط برای OrderRegister و OrderPayment</td>
  </tr>
  <tr>
    <td class="tg-0pky">Open-Close Principle</td>
    <td class="tg-0pky">با توجه به کد نوشته شده در قدم‌های دوم و سوم ثبت سفارش (انتخاب روش پرداخت و پرداخت هزینه) در صورتی که نوع جدیدی از OrderService را بخواهیم پیاده‌سازی کنیم، لازم است که این ک‌د‌ها هم تغییر کنند و علاوه‌بر نمونه‌گیری از کلاس پیاده‌کننده‌ی جدید آن، لازم است که در ادامه با رفلکشن چک کنیم که اگر کلاس سرویس ما از نوع سرویس جدید بود، تابع مخصوص به آن را صدا بزند.<br></td>
    <td class="tg-0pky">با پیاده سازی دو واسط نامبرده شده، برای ساخت هر OrderService جدید،&nbsp;&nbsp;کافیست دو کلاس برای OrderRegister و <br>OrderPayment ساخته شود و در واقع کد توسعه داده می‌شود ولی کدهای قبلی تغییر نمی‌کند</td>
  </tr>
  <tr>
    <td class="tg-0pky">Interface Segregation Principle</td>
    <td class="tg-0pky"><span style="font-weight:400;font-style:normal">نباید یک واسط بزرگ داشت که به صورت جزئی توابعی که کلاس‌های پیاده‌کننده آن هر کدام جداگانه به یکی احتیاج دارند، همگی در آن وجود داشته باشند و تمام پیاده‌کنندگان مجبور به پیاده‌ کردن آن باشند.</span></td>
    <td class="tg-0pky">کافی است که در هر یک از دو واسط جدید نامبرده، یک تابع وجود داشته باشد، که به ترتیب OrderRegister&nbsp;&nbsp;و OrderPayment خواهند بود. </td>
  </tr>
  <tr>
    <td class="tg-0pky">Dependency Inversion Principle</td>
    <td class="tg-0pky"><span style="font-weight:400;font-style:normal">۱. از قدم دوم یعنی انتخاب روش پرداخت، به صورت جزئی از کلاس‌های سطح پایین استفاده کرده است که باعث نقض DIP می‌شود.</span><br><span style="font-weight:400;font-style:normal">۲. یک مورد دیگر که از این اصل رعایت نشده، این است که جزییات در واسط انتزاعی وارد شد‌ه‌اند و دیگر در واسطمان نگاه سطح بالا به فرایند پرداخت وجود ندارد</span></td>
    <td class="tg-0pky">با پیاده سازی واسط‌های نامبرده شده، کافیست که برای استفاده&nbsp;&nbsp;از یک روش Order، از یک Factory method استفاده کنیم و اشیاء را از نوع واسط نگه داریم</td>
  </tr>
</tbody></table>
