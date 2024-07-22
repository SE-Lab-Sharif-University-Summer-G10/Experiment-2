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
.tg .tg-0lax{text-align:left;vertical-align:top}
</style>
<table class="tg"><thead>
  <tr>
    <th class="tg-0pky" rowspan="2">اصل ۱<br>Single Responsibility Principle</th>
    <th class="tg-0pky">موارد تحقق</th>
    <th class="tg-0pky">-</th>
  </tr>
  <tr>
    <th class="tg-0pky">موارد تقض</th>
    <th class="tg-0pky">واسطی که برای OrderService نوشته شده است توانایی انجام هر دو کار ثبت و پرداخت سفارش را دارد که این عملا نقض‌کننده‌ی SRP است.</th>
  </tr></thead>
<tbody>
  <tr>
    <td class="tg-0pky" rowspan="2">اصل ۲<br>Open-Closed Principle</td>
    <td class="tg-0pky">موارد تحقق</td>
    <td class="tg-0pky">-</td>
  </tr>
  <tr>
    <td class="tg-0lax">موارد نقض</td>
    <td class="tg-0lax">با توجه به کد نوشته شده در قدم‌های دوم و سوم ثبت سفارش (انتخاب روش پرداخت و پرداخت هزینه) در صورتی که نوع جدیدی از OrderService را بخواهیم پیاده‌سازی کنیم، لازم است که این ک‌د‌ها هم تغییر کنند و علاوه‌بر نمونه‌گیری از کلاس پیاده‌کننده‌ی جدید آن، لازم است که در ادامه با رفلکشن چک کنیم که اگر کلاس سرویس ما از نوع سرویس جدید بود، تابع مخصوص به آن را صدا بزند.</td>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="2">اصل ۳<br>Liskov Substitution<br>Principle</td>
    <td class="tg-0pky">موارد تحقق</td>
    <td class="tg-0pky">هر کلاسی که واسط OrderService را پیاده‌سازی کرد است، واقعا یک OrderService است و رابطه is-a بین واسط و کلاس برقرار است.</td>
  </tr>
  <tr>
    <td class="tg-0lax">موارد نقض</td>
    <td class="tg-0lax">-</td>
  </tr>
  <tr>
    <td class="tg-0lax" rowspan="2">اصل ۴<br>Interface Segregation Principle<br></td>
    <td class="tg-0lax">موراد تحقق</td>
    <td class="tg-0lax">-</td>
  </tr>
  <tr>
    <td class="tg-0lax">موارد نقض</td>
    <td class="tg-0lax">نباید یک واسط بزرگ داشت که به صورت جزئی توابعی که کلاس‌های پیاده‌کننده آن هر کدام جداگانه به یکی احتیاج دارند، همگی در آن وجود داشته باشند و تمام پیاده‌کنندگان مجبور به پیاده‌ کردن آن باشند.</td>
  </tr>
  <tr>
    <td class="tg-0lax" rowspan="2">اصل ۴<br>Dependency Inversion Principle</td>
    <td class="tg-0lax">موراد تحقق</td>
    <td class="tg-0lax">از آنجایی که تعریف نوع متغیر orderService از واسط سطح بالا صورت گرفته است، تا آنجا از کد، نگاه سطح بالا حفظ شده و عملا DIP داریم.</td>
  </tr>
  <tr>
    <td class="tg-0lax">موارد نقض</td>
    <td class="tg-0lax">۱. از قدم دوم یعنی انتخاب روش پرداخت، به صورت جزئی از کلاس‌های سطح پایین استفاده کرده است که باعث نقض DIP می‌شود.<br>۲. یک مورد دیگر که از این اصل رعایت نشده، این است که جزییات در واسط انتزاعی وارد شد‌ه‌اند و دیگر در واسطمان نگاه سطح بالا به فرایند پرداخت وجود ندارد</td>
  </tr>
</tbody></table>
