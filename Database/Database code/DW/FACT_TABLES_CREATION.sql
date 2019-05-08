use DW;

create table Warning_D ( W_ID  int IDENTITY, 
Warning_ID  int  ,
m_Type     varchar(50),
status    varchar(50),
t_Stamp     datetime2(7),
value       varchar(255),
"ValidFrom" nvarchar(20) not null DEFAULT '01/05/2019',
	"Validto" nvarchar(20) not null DEFAULT '01/05/2099'

primary key (W_ID)

);


create table Room_D(
R_ID  int  IDENTITY, 
Room_ID  int,
room_name     varchar(50),
device_name    varchar(50),
"ValidFrom" nvarchar(20) not null DEFAULT '01/05/2019',
	"Validto" nvarchar(20) not null DEFAULT '01/05/2099'

primary key (R_ID)
);

create table "Calendar_D"(
	"D_ID" int identity (1, 1) NOT NULL,--identity (1,1) means autoincrement by 1, starting at 1
	
[CalendarDate] DATETIME,
 WeekDayName nvarchar(50),
  MonthName nvarchar(50) 
  constraint "PK_Date" primary key(
		"D_ID" 
	)
	)
	 go

  DECLARE @StartDate DATETIME 
  DECLARE @EndDate DATETIME 
  SET @StartDate= '2019-05-01' 
   SET @EndDate= DATEADD(d, 1095, @StartDate)
   WHILE @StartDate<= @EndDate
   BEGIN 
   INSERT INTO [Calendar_D](CalendarDate,WeekDayName,MonthName)
   SELECT 
   @StartDate,DATENAME(weekday,@startDate),
   DATENAME(month, @StartDate)SET @StartDate= DATEADD(dd, 1, @StartDate)END


   CREATE TABLE "Time_D"
(
  T_ID int identity (1,1) not null
, TimeStamp  TIME not null
, Minutes tinyint not null
, Seconds tinyint not null
,constraint "PK_Time_ID" primary key(
		"T_ID"
)
)
go
DECLARE @Hour TIME
DECLARE @EndHour TIME
SET @Hour = '08:20:01'
SET @EndHour = DATEADD(second,27900,@Hour)
WHILE (@Hour <= @EndHour)
BEGIN
INSERT INTO [Time_D]
(
TimeStamp,
Minutes,
Seconds
)
SELECT
@Hour
,DATENAME(minute,@Hour)
,DATENAME(second, @Hour )
SET @Hour = DATEADD(second,1, @Hour)
END




create table Fact_CO2 (D_ID   int,
R_ID int,
W_ID   int,
T_ID    int,
value varchar(255),

primary key (D_ID,R_ID, W_ID, T_ID),
foreign key ("D_ID") references [DW].[dbo].[Calendar_D] ( "D_ID" ),
foreign key ("R_ID") references [DW].[dbo].[Room_D] ( "R_ID" ),
foreign key ("W_ID") references [DW].[dbo].[Warning_D] ( "W_ID" ) ,
foreign key ("T_ID") references [DW].[dbo].[Time_D] ( "T_ID" ) 

);


create table Fact_Temperature (D_ID   int,
R_ID int,
W_ID   int,
T_ID    int,
value varchar(255),

primary key (D_ID,R_ID, W_ID, T_ID),
foreign key ("D_ID") references [DW].[dbo].[Calendar_D] ( "D_ID" ),
foreign key ("R_ID") references [DW].[dbo].[Room_D] ( "R_ID" ),
foreign key ("W_ID") references [DW].[dbo].[Warning_D] ( "W_ID" ) ,
foreign key ("T_ID") references [DW].[dbo].[Time_D] ( "T_ID" ) 

);



create table Fact_Humidity (D_ID   int,
R_ID int,
W_ID   int,
T_ID    int,
value varchar(255),

primary key (D_ID,R_ID, W_ID, T_ID),
foreign key ("D_ID") references [DW].[dbo].[Calendar_D] ( "D_ID" ),
foreign key ("R_ID") references [DW].[dbo].[Room_D] ( "R_ID" ),
foreign key ("W_ID") references [DW].[dbo].[Warning_D] ( "W_ID" ) ,
foreign key ("T_ID") references [DW].[dbo].[Time_D] ( "T_ID" ) 

);