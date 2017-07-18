### Spring AOP ve AspectJ

### AOP nedir?

Açılımı Aspect Oriented Programming'dir. Yazdığımız kodların modülerliğini arttırarak daha kullanışlı projeler oluşturmamızı
sağlar. Yazdığımız kodlarda sürekli kullandığımız kontrol, loglama işlemlerinin ayrı bir katmana taşınarak diğer fonksiyonlar
tarafından da kullanılmasını sağlar.

OOP'de sınıflarla sağladığımız modülerlik, AOP'de aspectler sayesinde sağlanır. OOP'nin modülerlik konusunda eksiklerini tamamlar
diyebiliriz. Örneğin transaction yönetimleri için bir sınıf oluşturup gerekli işlemleri içerisinde tanımlı fonksiyonlar sayesinde 
yapsakta, bu fonksiyonları kullanabilmek için ilgili sınıftan bir nesne oluşturmamız gereklidir(fonksiyonlar static olmadığı sürece).

### AOP Temel Birimleri

AOP'nin temel yapısında bilinmesi gereken birkaç tanım vardır.

#### Aspect

Kodlarımızda kesişen yapıların toplandığı sınıflardır. Örneğin; loglama işlemleri için kesişen kodları bu sınıflarda toplayarız.

#### Join Point 

Birleşim noktası anlamındadır. Advice ve join pointler, pointcut yardımıylı birleştirilir ve ilgili java biriminin işletilmesinden önce, 
sonra ya da işletilirken aspect kodları çalıştırılır. Method execution, method call, field write access, constructor execution gibi çeşitli
birleşim noktaları vardır. Spring AOP' de join pointler daima method executiondır.

#### Pointcut 

Join point ile advice yapılarını birleştirir. AspectJ pointcut expression language ile tanımlanırlar ve join pointleri işaret ederek adviceların
bu noktalara bağlanmasını sağlarlar. 2 farklı pointcut tipi vardır; named pointcut ve anonymous pointcut.

Java sınıf birimlerini ifade edebilmek için 4 temel pointcut signature vardır.

* Type signature pattern: Class, interface ve veri tiplerini seçmek için kullanılır. Örnek; *Aspects signature ile sonu Aspect ile biten tüm sınıf, interfacelere ulaşılabilir.
* Method signature pattern: Projemizde yer alan metotlara ulaşmak için kullanılır. Örnek; * *(..) signature ile projemizde ki tüm fonksiyonları işaretleriz.
* Constructor signature pattern: Sınıflarımızın kurucularına ulaşmak için kullanılır. Örnek *.new(..) signature ile tüm kurucu fonksiyonlar işaretlenir.
* Field signature pattern: sınıflarımızın set ve get metotları hedef alınır. Örnek get(..) signature ile tüm get metotları işaretlenir.

Diğer pointcut imzaları:

withincode: Bir metot ya da kurucu içerisinde ki herhangi bir birleşim noktasını ifade eder. Örnek withincode(* *(..)) tüm fonksiyonların içerisinde ki birleşim noktalarını ifade eder.
within: Sınıflar ve iç sınıfların içerisinde ki birleşim noktalarını ifade eder. Örnek com.oonukuru.spring.Example+ Example sınıfını ve ondan türeyen sınıfların birleşim noktalarını ifade eder.

#### Advice

Pointcut ile seçilen join pointlerde ilgili kodların ne zaman çalıştırılacağını belirtir. 3 farklı advice tipi vardır.

* Before advice: Join Pointden önce çalışır.
* After advice: Join Pointden sonra çalışır. Bu advice tipide 3 farklı tipe ayrılır.
    * After advice: Join Point noktasında hata olup olmamasına bakılmaksızın çalışacak kodları belirtir.
    * After throwing advice: Join Point noktalarında bir hata meydana geldiği zaman çalışacak kodları belirtir.
    * After returning advice: Join Point noktalarında bir hata meydana gelmeden işlem tamamlandığında çalışacak kodları belirtir.
* Around advice: Joint Pointi sarmalar. Belirli işlemler yapıldıktan sonra proceed() fonksiyonu ile join point noktaları işletilebilir ya da atlanabilir.    

### Pointcut expression language
 
 Spring AOP, AspectJ pointcut expression languageyi destekler.
 
* + sembolü: İşaretlenen birimin alt birimlerini belirtir.
* .. sembolü: Metotlar için parametre sayısının ve tipinin önemsenmediğini, paketler için tüm alt paketlerin dahil edileceği anlamındadır.
* * sembolü: Kullanım yerine göre metotlar, paketler, dönüş tipleri, sınıf isimleri vs. her şeyin kabul edileceği anlamına gelmektedir.

Pointcut çeşitleri:

* execution: Method execution join pointleriyle eşleşir. execution(<erişim belirteci> <dönüş tipi> <hedef fonksiyon>(<parametreler>)) şeklinde kullanımı vardır.

Örneğin; 

    * execution(\* com.oonurkuru.spring.services.PersonService.\*(..)) tanımlaması ile PersonService sınıfı içerisindeki tüm fonksiyonlar işaretlenir.
    * execution(\* com.oonurkuru.spring.services..\*(..)) services paketi içerisindeki tüm fonksiyonlar işaretlenir.
    
* within: Paketleri kullanarak join pointlere erişimi sağlar. within(<paket ismi>.<Sınıf ismi>)

Örneğin;

    * within(com.oonurkuru.spring.services.PersonService) Person Service içerisindeki joint pointleri ifade eder.
    * within(com.oonurkuru.spring.services..) services packages içerisindeki sınıflara ait join pointleri ifade eder.

* this ve target: Bu pointcutlar join pointlerin sınıf tiplerine göre belirlenmesini sağlar.
* args: Join pointlerin parametreler yardımıyla belirlenmisini sağlar.

Örneğin;
    
    * execution(* *..find*(Long)) find ile başlayan ve Long tipli parametresi olan fonksiyonları işaret eder.
     
[AOP ve AspectJ hakkında detaylı bilgiye buradan ulaşabilirsiniz](https://blog.kodcu.com/2014/09/aspectj-ile-aspect-oriented-programming/)