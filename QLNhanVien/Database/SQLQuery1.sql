create database NhanVien
go

use NhanVien
go

CREATE TABLE [dbo].[NhanVien](	 
	[Ma] [varchar](20)  NOT NULL PRIMARY KEY, 
	[Ten] [nvarchar](30) NULL,	
	[GioiTinh] [nvarchar](10) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[MatKhau] [varchar](max) NULL,	
)

INSERT into[dbo].[NhanVien] ( [Ma], [Ten], [GioiTinh], [DiaChi], [MatKhau])
VALUES ( N'Hvt15', N'Võ Tạ Hoàng',  N'Nam',  N'Số 4 Trịnh Văn Bô', N'123456')

INSERT into[dbo].[NhanVien] ( [Ma], [Ten], [GioiTinh], [DiaChi], [MatKhau])
VALUES ( N'ManhPH34757', N'Nguyễn Ngọc Mạnh',  N'Nam',  N'406 Xuân Phương', N'270704')

INSERT into[dbo].[NhanVien] ( [Ma], [Ten], [GioiTinh], [DiaChi], [MatKhau])
VALUES ( N'Hvt13', N'Võ Tấn Hoàng',  N'Nam',  N'Số 10 Trịnh Văn Bô', N'654321')

INSERT into[dbo].[NhanVien] ( [Ma], [Ten], [GioiTinh], [DiaChi], [MatKhau])
VALUES ( N'AnhPH34758', N'Nguyễn Ngọc Ánh',  N'Nữ',  N'110 Trần Phú', N'170914')

select * from nhanVien