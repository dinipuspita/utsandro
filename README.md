# utsandro
# Nama	: Dini Puspita Sari (07)
#     	  Luis Santiago (18)

# Judul Aplikasi : Novel Inc

# Deskripsi Aplikasi : 

Novel inc adalah aplikasi berbasis android yang terdiri dari 2 user dengan level yang berbeda yaitu admin dan user.Dimana antara user tersebut mempunyai hak akses yang berbeda yaitu, admin dapat melakukan CRUD(Create, Read, Update, dan Delete) pada data, Sedangkan user hanya dapat melakukan Read data yang ada pada list dan detail dari data novel. Untuk dapat masuk pada aplikasi tersebut user disediakan halaman login yang username dan passwordnya berbeda antara admin dan user.Setelah admin login maka akan langsung masuk pada halaman tampil data terbaru yang telah dilakukan perubahan baik create, update, maupun delete. Sedangkan user setelah login akan di arahkan ke menu list novel dimana pada list item tersebut nantinya akan dapat melihat detail dari setiap itemnya.

# Requirement ( Android OS dan level)
Aplikasi ini dapat dibuka pada android OS dengan level android dengan versi sandwich 

# List Class yang ada & deskripsi singkatnya

Activity_main.xml	  : Digunakan untuk membuat layout login
MainActivity .java	: Digunakan untuk membuat system multiuser, validasi, menyimpan data login dan logout (Shared Preferences)
HomeActivity.java	  : Digunakan untuk membuat 
Activity_main2.xml 	: Digunakan untuk menampilkan data terbaru yang ada pada database  dan  membuat intent ke halaman ViewNovel dan dan                       UpdateNovel
Main2Activity.java	: Digunakan untuk membuat layout tampil data terbaru
Activity_main3.xml	: Digunakan untuk membuat data yang akan ditampilkan pada  recycler view dan membuat intent ke halaman detail item
MyDataHelper.java	  : Digunakan untuk membuat database dan table yang ada di database serta values-values yang ada pada table di data                            base
InsertNovel.java	  : Digunakan untuk membuat system insert data berdasarkan values-values yang ada pada table dalam database 
Activity_insert_novel.xml	:Digunakan untuk membuat layout insert data novel
UpdateNovel.java	  : Digunakan untuk membuat system update data berdasarkan values-values yang ada pada table dalam database dan memperbarui data
Activity_iupdate_novel.xml	: Digunakan untuk membuat layout update data novel
Activity_list_data.xml	    : Digunakan untuk membuat layout dan menampilkan recycler view berupa list view 

Details.java 	        : Digunakan untuk membuat system detail yang memanggil data-data yang ada pada recycler view sebelumnya
Activity_details.xml	: Digunakan untuk membuat layout halaman detail
MyDataAdapter.java	  : Digunakan untuk membuat data ViewHolder pada recycler view
MyData .java	        : Digunakan untuk membuat constructor dan setter getter dan memproses data recycler view
RecyclerTouchListener.java	  : Digunakan untuk menampilkan halaman detail saat dilakukan klik pada item
ClicListener(interface class)	: Digunakan untuk membuat konstanta dan method untuk 




