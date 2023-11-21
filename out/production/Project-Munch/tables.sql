create table Restaurants(
  restID integer primary key auto_increment,
  name varchar(50) not null,
  location varchar(50) not null
);

create table Users(
  userID integer primary key auto_increment,
  name varchar(50) not null,
  username varchar(50) not null
);

create table Ratings(
  ratingID integer primary key auto_increment,
  restID integer,
  rating integer not null,
  userID integer,
  foreign key(userID) references Users(userID),
  foreign key(restID) references Restaurants(restID)
);

create table Reviews(
  ratingID integer primary key,
  restID integer,
  review varchar(200),
  foreign key(ratingID) references Ratings(ratingID),
  foreign key(restID) references Restaurants(restID)
);

