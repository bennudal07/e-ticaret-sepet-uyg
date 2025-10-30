import java.util.ArrayList;
import java.util.Scanner;
//Soyutlama: sadece ihtiyaç duyulan bilgilerin kullanıcıya sunulması ve gereksiz detayların saklanmasıdır.
//  SOYUT SINIF (ürünlerin ortak yapısı tanımlandı ve gereksiz detaylar gizlendi.)
abstract class Urun {
    //private ile dışarıdan erişim engellenip kapsülleme sağlandı.(kontrollü erişim)
    private String ad;
    private double fiyat;

    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }
    //kapsülleme sayesinde veriyi koruduk.Sadece getter metodları ile bu yapılara erişilebilir.
    public String getAd() {
        return ad;
    }

    public double getFiyat() {
        return fiyat;
    }
    //Çok Biçimlilik: Aynı isimdeki metodun farklı sınıflarda farklı davranmasıdır.
//bilgiGoster() her üründe farklı çalışmasına çok biçimlilik diyoruz.
    public abstract void bilgiGoster();
}
//Kalıtım:Bir üst sınıftan özelliklerin miras alınmasıdır.
//extends Urun yazan kısımlarında kalıtım özelliğini kullandık.Üst satırlarda belirttiğimiz ad ve fiyat özelliklerini otomatik alarak aynı kodun tekrar yazılmasına engel olunuyor.
// Elektronik Ürün
class ElektronikUrun extends Urun {
    private int garantiYili;

    public ElektronikUrun(String ad, double fiyat, int garantiYili) {
        super(ad, fiyat);
        this.garantiYili = garantiYili;
    }

    @Override //Bu bilgiGoster() metodu, Urun sınıfındaki soyut metodun yeni halidir.(override bu amaçla kullanılır.)
    public void bilgiGoster() {
        System.out.println("Elektronik Ürün: " + getAd() +
                " | Fiyat: " + getFiyat() + "₺ | Garanti: " + garantiYili + " yıl");
    }
}

// Giyim Ürünü
class GiyimUrunu extends Urun {
    private String beden;

    public GiyimUrunu(String ad, double fiyat, String beden) {
        super(ad, fiyat);
        this.beden = beden;
    }

    //  Beden sonradan seçilecekse "-" default atanır
    public GiyimUrunu(String ad, double fiyat) {
        super(ad, fiyat);
        this.beden = "-";
    }

    public String getBeden() {
        return beden;
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Giyim Ürünü: " + getAd() +
                " | Fiyat: " + getFiyat() + "₺" +
                (beden.equals("-") ? "" : " | Beden: " + beden));
    }
}

// Kişisel Bakım Ürünü
class KisiselBakimUrunu extends Urun {
    public KisiselBakimUrunu(String ad, double fiyat) {
        super(ad, fiyat);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Kişisel Bakım Ürünü: " + getAd() + " | Fiyat: " + getFiyat() + "₺");
    }
}

// SEPET SINIFI
// Sepete ürün ekleme, çıkarma ve gösterme işlemleri buradadır.
class Sepet {
    private ArrayList<Urun> urunler = new ArrayList<>();

    //sepete ürün eklenir.
    public void urunEkle(Urun urun) {
        urunler.add(urun);
        System.out.println(urun.getAd() + " sepete eklendi!");
    }

    //ürün isim ile sepetten çıkarılır.
    public void urunCikar(String urunAdi) {
        boolean bulundu = false;
        for (int i = 0; i < urunler.size(); i++) {
            if (urunler.get(i).getAd().equalsIgnoreCase(urunAdi)) {
                System.out.println(urunler.get(i).getAd() + " sepetten çıkarıldı!");
                urunler.remove(i);
                bulundu = true;
                break;
            }
        }
        if (!bulundu) {
            System.out.println("Bu isimde bir ürün sepette bulunamadı!");
        }
    }

    //sepetteki ürünleri listeler.
    public void sepetGoster() {
        System.out.println("\n🛒 Sepetiniz:");
        if (urunler.isEmpty()) {
            System.out.println("Sepet boş!");
        } else {
            for (Urun u : urunler) {
                u.bilgiGoster();
            }
            System.out.println("Toplam Tutar: " + toplamTutarHesapla() + "₺");
        }
    }

    //ürünlerin toplam tutarını hesaplar.
    public double toplamTutarHesapla() {
        double toplam = 0;
        for (Urun u : urunler) {
            toplam += u.getFiyat();
        }
        return toplam;
    }
}

// ANA SINIF
public class Main {
    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);

//örnek ürünler oluşturuyoruz.
        ElektronikUrun laptop = new ElektronikUrun("Laptop", 25000, 2);
        ElektronikUrun telefon = new ElektronikUrun("Telefon", 18000, 1);
        ElektronikUrun televizyon = new ElektronikUrun("Televizyon", 15000, 2);
        ElektronikUrun akilli_saat = new ElektronikUrun("Akıllı Saat", 3000, 2);
        ElektronikUrun bluetooth_kulaklık = new ElektronikUrun("Bluetooth Kulaklık", 4000, 1);
        ElektronikUrun elektrik_supurgesi = new ElektronikUrun("Elektrik Süpürgesi", 5000, 2);
        GiyimUrunu tisort = new GiyimUrunu("Tişört", 250);
        GiyimUrunu pantolon = new GiyimUrunu("Pantolon", 600);
        GiyimUrunu gomlek = new GiyimUrunu("Gömlek", 500);
        GiyimUrunu kazak = new GiyimUrunu("Kazak", 450);
        GiyimUrunu ayakkabi = new GiyimUrunu("Ayakkabı", 1000);
        GiyimUrunu canta = new GiyimUrunu("Çanta", 800);
        GiyimUrunu mont = new GiyimUrunu("Mont", 1500);
        KisiselBakimUrunu yuz_temizleme_jeli = new KisiselBakimUrunu("Yüz Temizleme Jeli", 200);
        KisiselBakimUrunu maske = new KisiselBakimUrunu("Maske", 150);
        KisiselBakimUrunu nemlendirici = new KisiselBakimUrunu("Nemlendirici", 250);
        KisiselBakimUrunu tonik = new KisiselBakimUrunu("Tonik", 150);

//Tüm ürünleri liste içine ekliyoruz.
        ArrayList<Urun> urunListesi = new ArrayList<>();
        urunListesi.add(laptop);
        urunListesi.add(telefon);
        urunListesi.add(televizyon);
        urunListesi.add(akilli_saat);
        urunListesi.add(bluetooth_kulaklık);
        urunListesi.add(elektrik_supurgesi);
        urunListesi.add(tisort);
        urunListesi.add(pantolon);
        urunListesi.add(gomlek);
        urunListesi.add(kazak);
        urunListesi.add(ayakkabi);
        urunListesi.add(canta);
        urunListesi.add(mont);
        urunListesi.add(yuz_temizleme_jeli);
        urunListesi.add(maske);
        urunListesi.add(nemlendirici);
        urunListesi.add(tonik);

        Sepet sepet = new Sepet(); //sepet oluşturma

        int secim;
        do {
            //kullanıcı menüsü
            System.out.println("\n====== E-Ticaret Sepet Uygulaması ======");
            System.out.println("1. Ürünleri Listele");
            System.out.println("2. Ürünü Sepete Ekle");
            System.out.println("3. Ürünü Sepetten Çıkar");
            System.out.println("4. Sepeti Görüntüle");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = giris.nextInt(); //Boşta kalan Enter karakterini siler
            giris.nextLine(); // buffer temizliği (Kullanıcıdan alınan bir sonraki metin girişinin bozulmaması için)

            switch (secim) {
                case 1:
                    System.out.println("\n--- Ürün Listesi ---");
                    //ürünleri numaralandırarak göster
                    for (int i = 0; i < urunListesi.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        urunListesi.get(i).bilgiGoster();
                    }
                    break;

                case 2:
                    System.out.print("Sepete eklemek istediğiniz ürün numarasını girin: ");
                    int urunNo = giris.nextInt();
                    giris.nextLine(); // buffer temizliği

                    //seçim geçerliyse devam et
                    if (urunNo > 0 && urunNo <= urunListesi.size()) {
                        Urun secilenUrun = urunListesi.get(urunNo - 1);

                        // Giyim ürünleri için beden/numara seçimi
                        if (secilenUrun instanceof GiyimUrunu) {
                            GiyimUrunu eski = (GiyimUrunu) secilenUrun;
                            String ad = eski.getAd().toLowerCase();

                            // Ayakkabı ise numara sor
                            if (ad.contains("ayakkabı")) {
                                System.out.print("Numara seçin (37 / 38 / 39 / 40 / 41 / 42): ");
                                String secilenNumara = giris.nextLine();
                                //yeni ayakkabı nesnesi oluşturulur.
                                GiyimUrunu yeni = new GiyimUrunu(eski.getAd(), eski.getFiyat(), secilenNumara);
                                sepet.urunEkle(yeni);

                                // Çanta ise beden sorma
                            } else if (ad.contains("çanta")) {
                                sepet.urunEkle(eski);

                                // Diğer giyim ürünleri için klasik beden seçimi
                            } else {
                                System.out.print("Beden seçin (S / M / L / XL): ");
                                String secilenBeden = giris.nextLine().toUpperCase();
                                GiyimUrunu yeni = new GiyimUrunu(eski.getAd(), eski.getFiyat(), secilenBeden);
                                sepet.urunEkle(yeni);
                            }
                        } else {
                            // Giyim dışındaki ürünler direkt eklenir
                            sepet.urunEkle(secilenUrun);
                        }
                    } else {
                        System.out.println("Geçersiz ürün numarası!");
                    }
                    break;


                case 3:
                    System.out.print("Çıkarmak istediğiniz ürünün adını girin: ");
                    String urunAdi = giris.nextLine();
                    sepet.urunCikar(urunAdi);
                    break;

                case 4:
                    sepet.sepetGoster();
                    break;

                case 0:
                    System.out.println("Programdan çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (secim != 0);
    }
}
