# mobiroller-interview
This is an interview.


Proje 3 screenden oluşmaktadır. Kayıt, Listeme&Siralama ve Detay screenleridir.

* Authentication belirtilmediği için projede bulunmamaktadır.

* Projede kullanılan Architecture Design, MVP (Model - View - Presenter) yapısıdır.

* Projede kullanılan Design Patternlar, dependency injection (Dagger 2 ile kullanıldı) ve onunla birlikte Singleton pattern da bulunmaktadır. 

* Firebase üzerinde order by function için descending olmadığı için reverse function kullanıldı.

* Normalde Category i ayrı bir tip olarak tanımlamak istemiştim ama ekstra DML işlemleri olacağından ötürü süreç uzayabilirdi. O yüzden o kısmı static yaptım.

Diğer Bağımlılıklar

* butterknife

Not: Firebase Realtime Database deneyimim çok yoktur, tutorial a sabit kalınmıştır.

Sonradan aklıma geldiği için kendime Feedback bırakabilirim. Bottom navigation kullanmadan, mainActivity e FloatingButton koyularak daha sade ve hoş bir UX sağlanabilirdi. Maalesef sonradan aklıma geldi. Onu da belirtmek istedim.
