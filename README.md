# Java E-Ticaret Sepet Uygulaması

Bu proje, Nesne Yönelimli Programlama (OOP) kavramlarını kullanarak basit bir E-Ticaret Sepet Sistemi oluşturur.
Kullanıcı ürünleri listeleyebilir, sepete ekleyebilir, sepetten çıkarabilir, sepet içeriğini görüntüleyebilir ve toplam tutarı görebilir.
Ayrıca proje nesneye yönelik programlama kavramlarından, soyutlama, kapsülleme, kalıtım ve çok biçimlilik kavramlarını örneklemektedir.

## 🚀 Özellikler

- **Soyutlama:** `Urun` soyut sınıfı ile ortak özelliklerin tanımlanması  
- **Kapsülleme:** Ürün bilgilerine yalnızca getter metotlarıyla erişim  
- **Kalıtım:** Elektronik, Giyim ve Kişisel Bakım sınıfları `Urun`’dan türetilmiştir  
- **Çok Biçimlilik:** Her ürün türü `bilgiGoster()` metodunu kendine özgü biçimde uygular  
- **Sepet İşlemleri:** Ürün ekleme, çıkarma ve toplam tutar hesaplama
-**Giyim Ürünlerinde Beden/Numara Seçimi:** Kullanıcı beden veya numara belirleyebilir

  ## Kullanılan Sınıflar

| Sınıf | Açıklama |
|-------|-----------|
| `Urun` | Soyut sınıf – tüm ürün türlerinin temelini oluşturur |
| `ElektronikUrun` | Elektronik ürünlerin özelliklerini içerir (örneğin garanti süresi) |
| `GiyimUrunu` | Giyim ürünleri için beden/numara bilgisini tutar |
| `KisiselBakimUrunu` | Kişisel bakım ürünlerini temsil eder |
| `Sepet` | Sepete ürün ekleme, çıkarma ve toplam hesaplama işlemlerini yapar |
| `Main` | Programın çalıştığı ana sınıf – kullanıcı menüsü burada yer alır |

## Uygulamada Kullanılan OOP Kavramları

- **Soyutlama:**  
  `abstract class Urun` içinde sadece gerekli bilgiler tanımlanır.  
- **Kapsülleme:**  
  `private` değişkenler sadece `get` metotlarıyla erişilebilir.  
- **Kalıtım:**  
  `ElektronikUrun`, `GiyimUrunu`, `KisiselBakimUrunu` sınıfları `Urun`’dan türetilmiştir.  
- **Çok Biçimlilik:**  
  Her alt sınıf `bilgiGoster()` metodunu kendi türüne uygun biçimde yeniden yazar.

  ## Örnek Çalışma

--- Ürün Listesi ---

Elektronik Ürün: Laptop | Fiyat: 25000₺ | Garanti: 2 yıl

Giyim Ürünü: Tişört | Fiyat: 250₺
...

Sepete eklemek istediğiniz ürün numarasını girin: 2
Beden seçin (S / M / L / XL): M
Tişört sepete eklendi!

Sepetiniz:
Giyim Ürünü: Tişört | Fiyat: 250₺ | Beden: M
Toplam Tutar: 250₺

  ## Kullanılan Teknolojiler

- **Java** (JDK 8 veya üzeri)  
- **OOP (Nesne Yönelimli Programlama)** prensipleri  
- **ArrayList** (dinamik veri tutma yapısı)  
- **Scanner** (kullanıcıdan veri girişi)

  ## Çalıştırma

1. Proje dosyalarını indir veya klonla.
2. Kodu derle ve çalıştır.

  

  
