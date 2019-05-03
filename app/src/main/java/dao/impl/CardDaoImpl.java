package dao.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import dao.CardDao;
import Model.Card;

public class CardDaoImpl extends SQLiteOpenHelper implements CardDao {
    private final static String DATABASE_NAME = "tarot";
    private final static int DATABASE_VERSION = 1;

    public CardDaoImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public Card getCard(String idCard) {
        Card card = new Card();
        try {
            SQLiteDatabase db = getReadableDatabase();
            String sql = "SELECT * FROM card WHERE idCard = " + idCard;
            Cursor result = db.rawQuery(sql, null);
            while(result.moveToNext()) {
                card.setIdCard(result.getString(0));
                card.setIdTypeCard(result.getInt(1));
                card.setOrientCard(result.getInt(2));
                card.setNameCard(result.getString(3));
                card.setImageCard(result.getString(4));
                card.setText(result.getString(5));
            }
        } catch(Exception e) {
        }
        return card;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table typeCard
        String sql = "CREATE TABLE typecard(" +
                "idTypeCard INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nameType TEXT)";
        db.execSQL(sql);
        // Create table card
        sql = "CREATE TABLE card(" +
                "idCard TEXT PRIMARY KEY NOT NULL," +
                "idTypeCard INTEGER NOT NULL," +
                "orientCard INTEGER," +
                "nameCard TEXT," +
                "linkImageCard TEXT," +
                "linkText TEXT," +
                "FOREIGN KEY(idTypeCard) REFERENCES typecard(idTypeCard));";
        db.execSQL(sql);
        // Insert data into table typecard
        sql = "INSERT INTO typecard (nameType) VALUES" +
                "('Major Arcana')," +
                "('Cups')," +
                "('Pentacles')," +
                "('Swords')," +
                "('Wands')";
        db.execSQL(sql);
        sql = "INSERT INTO card(idCard, idTypeCard, orientCard, nameCard, linkImageCard, linkText) VALUES" +
                "('001', 1, 0, 'The Fool','MajorArcana/0_TheFool_0.png','MajorArcana/0_TheFool_0.txt')," +
                "('002', 1, 1, 'The Fool','MajorArcana/0_TheFool_0.png','MajorArcana/0_TheFool_01.txt')," +
                "('003', 1, 0, 'The Magician','MajorArcana/1_TheMagician_0.png','MajorArcana/1_TheMagician_0.txt')," +
                "('004', 1, 1, 'The Magician','MajorArcana/1_TheMagician_0.png','MajorArcana/1_TheMagician_1.txt')," +
                "('005', 1, 0, 'The High Priestess','MajorArcana/2_TheHighPriestess_0.png','MajorArcana/2_TheHighPriestess_0.txt')," +
                "('006', 1, 1, 'The High Priestess','MajorArcana/2_TheHighPriestess_0.png','MajorArcana/2_TheHighPriestess_1.txt')," +
                "('007', 1, 0, 'The Empress','MajorArcana/3_TheEmpress_0.png','MajorArcana/3_TheEmpress_0.txt')," +
                "('008', 1, 1, 'The Empress','MajorArcana/3_TheEmpress_0.png','MajorArcana/3_TheEmpress_1.txt')," +
                "('009', 1, 0, 'The Emperor','MajorArcana/4_The Emperor_0.png','MajorArcana/4_The Emperor_0.txt')," +
                "('010', 1, 1, 'The Emperor','MajorArcana/4_The Emperor_0.png','MajorArcana/4_The Emperor_1.txt')," +
                "('011', 1, 0, 'The Hierophant','MajorArcana/5_TheHierophant_0.png','MajorArcana/5_TheHierophant_0.txt')," +
                "('012', 1, 1, 'The Hierophant','MajorArcana/5_TheHierophant_0.png','MajorArcana/5_TheHierophant_1.txt')," +
                "('013', 1, 0, 'The Lovers','MajorArcana/6_TheLovers_0.png','MajorArcana/6_TheLovers_0.txt')," +
                "('014', 1, 1, 'The Lovers','MajorArcana/6_TheLovers_0.png','MajorArcana/6_TheLovers_1.txt')," +
                "('015', 1, 0, 'The Chariot','MajorArcana/7_TheChariot_0.png','MajorArcana/7_TheChariot_0.txt')," +
                "('016', 1, 1, 'The Chariot','MajorArcana/7_TheChariot_0.png','MajorArcana/7_TheChariot_1.txt')," +
                "('017', 1, 0, 'Strength','MajorArcana/8_Strength_0.png','MajorArcana/8_Strength_0.txt')," +
                "('018', 1, 1, 'Strength','MajorArcana/8_Strength_0.png','MajorArcana/8_Strength_1.txt')," +
                "('019', 1, 0, 'The Hermit','MajorArcana/9_TheHermit_0.png','MajorArcana/9_TheHermit_0.txt')," +
                "('020', 1, 1, 'The Hermit','MajorArcana/9_TheHermit_0.png','MajorArcana/9_TheHermit_1.txt')," +
                "('021', 1, 0, 'The Wheel Of Fortune','MajorArcana/10_TheWheelOfFortune_0.png','MajorArcana/10_TheWheelOfFortune_0.txt')," +
                "('022', 1, 1, 'The Wheel Of Fortune','MajorArcana/10_TheWheelOfFortune_0.png','MajorArcana/10_TheWheelOfFortune_1.txt')," +
                "('023', 1, 0, 'Justice','MajorArcana/11_Justice_0.png','MajorArcana/11_Justice_0.txt')," +
                "('024', 1, 1, 'Justice','MajorArcana/11_Justice_0.png','MajorArcana/11_Justice_1.txt')," +
                "('025', 1, 0, 'The Hanged Man','MajorArcana/12_TheHangedMan_0.png','MajorArcana/12_TheHangedMan_0.txt')," +
                "('026', 1, 1, 'The Hanged Man','MajorArcana/12_TheHangedMan_0.png','MajorArcana/12_TheHangedMan_1.txt')," +
                "('027', 1, 0, 'Death','MajorArcana/13_Death_0.png','MajorArcana/13_Death_0.txt')," +
                "('028', 1, 1, 'Death','MajorArcana/13_Death_0.png','MajorArcana/13_Death_1.txt')," +
                "('029', 1, 0, 'Temperance','MajorArcana/14_Temperance_0.png','MajorArcana/14_Temperance_0.txt')," +
                "('030', 1, 1, 'Temperance','MajorArcana/14_Temperance_0.png','MajorArcana/14_Temperance_1.txt')," +
                "('031', 1, 0, 'The Devil','MajorArcana/15_TheDevil_0.png','MajorArcana/15_TheDevil_0.txt')," +
                "('032', 1, 1, 'The Devil','MajorArcana/15_TheDevil_0.png','MajorArcana/15_TheDevil_1.txt')," +
                "('033', 1, 0, 'The Tower','MajorArcana/16_TheTower_0.png','MajorArcana/16_TheTower_0.txt')," +
                "('034', 1, 1, 'The Tower','MajorArcana/16_TheTower_0.png','MajorArcana/16_TheTower_1.txt')," +
                "('035', 1, 0, 'The Star','MajorArcana/17_TheStar_0.png','MajorArcana/17_TheStar_0.txt')," +
                "('036', 1, 1, 'The Star','MajorArcana/17_TheStar_0.png','MajorArcana/17_TheStar_1.txt')," +
                "('037', 1, 0, 'The Moon','MajorArcana/18_TheMoon_0.png','MajorArcana/18_TheMoon_0.txt')," +
                "('038', 1, 1, 'The Moon','MajorArcana/18_TheMoon_0.png','MajorArcana/18_TheMoon_1.txt')," +
                "('039', 1, 0, 'The Sun','MajorArcana/19_TheSun_0.png','MajorArcana/19_TheSun_0.txt')," +
                "('040', 1, 1, 'The Sun','MajorArcana/19_TheSun_0.png','MajorArcana/19_TheSun_1.txt')," +
                "('041', 1, 0, 'Judgement','MajorArcana/20_Judgement_0.png','MajorArcana/20_Judgement_0.txt')," +
                "('042', 1, 1, 'Judgement','MajorArcana/20_Judgement_0.png','MajorArcana/20_Judgement_1.txt')," +
                "('043', 1, 0, 'The World','MajorArcana/21_TheWorld_0.png','MajorArcana/21_TheWorld_0.txt')," +
                "('044', 1, 1, 'The World','MajorArcana/21_TheWorld_0.png','MajorArcana/21_TheWorld_1.txt')," +
                "('045', 2, 0, '2 Of Cups','MinorArcana/Cups/2OfCups_0.png','MinorArcana/Cups/2OfCups_0.txt')," +
                "('046', 2, 1, '2 Of Cups','MinorArcana/Cups/2OfCups_0.png','MinorArcana/Cups/2OfCups_1.txt')," +
                "('047', 2, 0, '3 Of Cups','MinorArcana/Cups/3OfCups_0.png','MinorArcana/Cups/3OfCups_0.txt')," +
                "('048', 2, 1, '3 Of Cups','MinorArcana/Cups/3OfCups_0.png','MinorArcana/Cups/3OfCups_1.txt')," +
                "('049', 2, 0, '4 Of Cups','MinorArcana/Cups/4OfCups_0.png','MinorArcana/Cups/4OfCups_0.txt')," +
                "('050', 2, 1, '4 Of Cups','MinorArcana/Cups/4OfCups_0.png','MinorArcana/Cups/4OfCups_1.txt')," +
                "('051', 2, 0, '5 Of Cups','MinorArcana/Cups/5OfCups_0.png','MinorArcana/Cups/5OfCups_0.txt')," +
                "('052', 2, 1, '5 Of Cups','MinorArcana/Cups/5OfCups_0.png','MinorArcana/Cups/5OfCups_1.txt')," +
                "('053', 2, 0, '6 Of Cups','MinorArcana/Cups/6OfCups_0.png','MinorArcana/Cups/6OfCups_0.txt')," +
                "('054', 2, 1, '6 Of Cups','MinorArcana/Cups/6OfCups_0.png','MinorArcana/Cups/6OfCups_1.txt')," +
                "('055', 2, 0, '7 Of Cups','MinorArcana/Cups/7OfCups_0.png','MinorArcana/Cups/7OfCups_0.txt')," +
                "('056', 2, 1, '7 Of Cups','MinorArcana/Cups/7OfCups_0.png','MinorArcana/Cups/7OfCups_1.txt')," +
                "('057', 2, 0, '8 Of Cups','MinorArcana/Cups/8OfCups_0.png','MinorArcana/Cups/8OfCups_0.txt')," +
                "('058', 2, 1, '8 Of Cups','MinorArcana/Cups/8OfCups_0.png','MinorArcana/Cups/8OfCups_1.txt')," +
                "('059', 2, 0, '9 Of Cups','MinorArcana/Cups/9OfCups_0.png','MinorArcana/Cups/9OfCups_0.txt')," +
                "('060', 2, 1, '9 Of Cups','MinorArcana/Cups/9OfCups_0.png','MinorArcana/Cups/9OfCups_1.txt')," +
                "('061', 2, 0, '10 Of Cups','MinorArcana/Cups/10OfCups_0.png','MinorArcana/Cups/10OfCups_0.txt')," +
                "('062', 2, 1, '10 Of Cups','MinorArcana/Cups/10OfCups_0.png','MinorArcana/Cups/10OfCups_1.txt')," +
                "('063', 2, 0, 'Ace Of Cups','MinorArcana/Cups/AceOfCups_0.png','MinorArcana/Cups/AceOfCups_0.txt')," +
                "('064', 2, 1, 'Ace Of Cups','MinorArcana/Cups/AceOfCups_0.png','MinorArcana/Cups/AceOfCups_1.txt')," +
                "('065', 2, 0, 'King Of Cups','MinorArcana/Cups/KingOfCups_0.png','MinorArcana/Cups/KingOfCups_0.txt')," +
                "('066', 2, 1, 'King Of Cups','MinorArcana/Cups/KingOfCups_0.png','MinorArcana/Cups/KingOfCups_1.txt')," +
                "('067', 2, 0, 'Knight Of Cups','MinorArcana/Cups/KnightOfCups_0.png','MinorArcana/Cups/KnightOfCups_0.txt')," +
                "('068', 2, 1, 'Knight Of Cups','MinorArcana/Cups/KnightOfCups_0.png','MinorArcana/Cups/KnightOfCups_1.txt')," +
                "('069', 2, 0, 'Page Of Cups','MinorArcana/Cups/PageOfCups_0.png','MinorArcana/Cups/PageOfCups_0.txt')," +
                "('070', 2, 1, 'Page Of Cups','MinorArcana/Cups/PageOfCups_0.png','MinorArcana/Cups/PageOfCups_1.txt')," +
                "('071', 2, 0, 'Queen Of Cups','MinorArcana/Cups/QueenOfCups_0.png','MinorArcana/Cups/QueenOfCups_0.txt')," +
                "('072', 2, 1, 'Queen Of Cups','MinorArcana/Cups/QueenOfCups_0.png','MinorArcana/Cups/QueenOfCups_1.txt')," +
                "('073', 3, 0, '2 Of Pentacles','MinorArcana/Pentacles/2OfPentacles_0.png','MinorArcana/Pentacles/2OfPentacles_0.txt')," +
                "('074', 3, 1, '2 Of Pentacles','MinorArcana/Pentacles/2OfPentacles_0.png','MinorArcana/Pentacles/2OfPentacles_1.txt')," +
                "('075', 3, 0, '3 Of Pentacles','MinorArcana/Pentacles/3OfPentacles_0.png','MinorArcana/Pentacles/3OfPentacles_0.txt')," +
                "('076', 3, 1, '3 Of Pentacles','MinorArcana/Pentacles/3OfPentacles_0.png','MinorArcana/Pentacles/3OfPentacles_1.txt')," +
                "('077', 3, 0, '4 Of Pentacles','MinorArcana/Pentacles/4OfPentacles_0.png','MinorArcana/Pentacles/4OfPentacles_0.txt')," +
                "('078', 3, 1, '4 Of Pentacles','MinorArcana/Pentacles/4OfPentacles_0.png','MinorArcana/Pentacles/4OfPentacles_1.txt')," +
                "('079', 3, 0, '5 Of Pentacles','MinorArcana/Pentacles/5OfPentacles_0.png','MinorArcana/Pentacles/5OfPentacles_0.txt')," +
                "('080', 3, 1, '5 Of Pentacles','MinorArcana/Pentacles/5OfPentacles_0.png','MinorArcana/Pentacles/5OfPentacles_1.txt')," +
                "('081', 3, 0, '6 Of Pentacles','MinorArcana/Pentacles/6OfPentacles_0.png','MinorArcana/Pentacles/6OfPentacles_0.txt')," +
                "('082', 3, 1, '6 Of Pentacles','MinorArcana/Pentacles/6OfPentacles_0.png','MinorArcana/Pentacles/6OfPentacles_1.txt')," +
                "('083', 3, 0, '7 Of Pentacles','MinorArcana/Pentacles/7OfPentacles_0.png','MinorArcana/Pentacles/7OfPentacles_0.txt')," +
                "('084', 3, 1, '7 Of Pentacles','MinorArcana/Pentacles/7OfPentacles_0.png','MinorArcana/Pentacles/7OfPentacles_1.txt')," +
                "('085', 3, 0, '8 Of Pentacles','MinorArcana/Pentacles/8OfPentacles_0.png','MinorArcana/Pentacles/8OfPentacles_0.txt')," +
                "('086', 3, 1, '8 Of Pentacles','MinorArcana/Pentacles/8OfPentacles_0.png','MinorArcana/Pentacles/8OfPentacles_1.txt')," +
                "('087', 3, 0, '9 Of Pentacles','MinorArcana/Pentacles/9OfPentacles_0.png','MinorArcana/Pentacles/9OfPentacles_0.txt')," +
                "('088', 3, 1, '9 Of Pentacles','MinorArcana/Pentacles/9OfPentacles_0.png','MinorArcana/Pentacles/9OfPentacles1.txt')," +
                "('089', 3, 0, '10 Of Pentacles','MinorArcana/Pentacles/10OfPentacles_0.png','MinorArcana/Pentacles/10OfPentacles_0.txt')," +
                "('090', 3, 1, '10 Of Pentacles','MinorArcana/Pentacles/10OfPentacles_0.png','MinorArcana/Pentacles/10OfPentacles_1.txt')," +
                "('091', 3, 0, 'Ace Of Pentacles','MinorArcana/Pentacles/AceOfPentacles_0.png','MinorArcana/Pentacles/AceOfPentacles_0.txt')," +
                "('092', 3, 1, 'Ace Of Pentacles','MinorArcana/Pentacles/AceOfPentacles_0.png','MinorArcana/Pentacles/AceOfPentacles_1.txt')," +
                "('093', 3, 0, 'King Of Pentacles','MinorArcana/Pentacles/KingOfPentacles_0.png','MinorArcana/Pentacles/KingOfPentacles_0.txt')," +
                "('094', 3, 1, 'King Of Pentacles','MinorArcana/Pentacles/KingOfPentacles_0.png','MinorArcana/Pentacles/KingOfPentacles_1.txt')," +
                "('095', 3, 0, 'Knight Of Pentacles','MinorArcana/Pentacles/KnightOfPentacles_0.png','MinorArcana/Pentacles/KnightOfPentacles_0.txt')," +
                "('096', 3, 1, 'Knight Of Pentacles','MinorArcana/Pentacles/KnightOfPentacles_0.png','MinorArcana/Pentacles/KnightOfPentacles_1.txt')," +
                "('097', 3, 0, 'Page Of Pentacles','MinorArcana/Pentacles/PageOfPentacles_0.png','MinorArcana/Pentacles/PageOfPentacles_0.txt')," +
                "('098', 3, 1, 'Page Of Pentacles','MinorArcana/Pentacles/PageOfPentacles_0.png','MinorArcana/Pentacles/PageOfPentacles_1.txt')," +
                "('099', 3, 0, 'Queen Of Pentacles','MinorArcana/Pentacles/QueenOfPentacles_0.png','MinorArcana/Pentacles/QueenOfPentacles_0.txt')," +
                "('100', 3, 1, 'Queen Of Pentacles','MinorArcana/Pentacles/QueenOfPentacles_0.png','MinorArcana/Pentacles/QueenOfPentacles_1.txt')," +
                "('101', 4, 0, '2 Of Swords','MinorArcana/Swords/2OfSwords_0.png','MinorArcana/Swords/2OfSwords_0.txt')," +
                "('102', 4, 1, '2 Of Swords','MinorArcana/Swords/2OfSwords_0.png','MinorArcana/Swords/2OfSwords_1.txt')," +
                "('103', 4, 0, '3 Of Swords','MinorArcana/Swords/3OfSwords_0.png','MinorArcana/Swords/3OfSwords_0.txt')," +
                "('104', 4, 1, '3 Of Swords','MinorArcana/Swords/3OfSwords_0.png','MinorArcana/Swords/3OfSwords_1.txt')," +
                "('105', 4, 0, '4 Of Swords','MinorArcana/Swords/4OfSwords_0.png','MinorArcana/Swords/4OfSwords_0.txt')," +
                "('106', 4, 1, '4 Of Swords','MinorArcana/Swords/4OfSwords_0.png','MinorArcana/Swords/4OfSwords_1.txt')," +
                "('107', 4, 0, '5 Of Swords','MinorArcana/Swords/5OfSwords_0.png','MinorArcana/Swords/5OfSwords_0.txt')," +
                "('108', 4, 1, '5 Of Swords','MinorArcana/Swords/5OfSwords_0.png','MinorArcana/Swords/5OfSwords_1.txt')," +
                "('109', 4, 0, '6 Of Swords','MinorArcana/Swords/6OfSwords_0.png','MinorArcana/Swords/6OfSwords_0.txt')," +
                "('110', 4, 1, '6 Of Swords','MinorArcana/Swords/6OfSwords_0.png','MinorArcana/Swords/6OfSwords_1.txt')," +
                "('111', 4, 0, '7 Of Swords','MinorArcana/Swords/7OfSwords0.png','MinorArcana/Swords/7OfSwords_0.txt')," +
                "('112', 4, 1, '7 Of Swords','MinorArcana/Swords/7OfSwords_0.png','MinorArcana/Swords/7OfSwords_1.txt')," +
                "('113', 4, 0, '8 Of Swords','MinorArcana/Swords/8OfSwords_0.png','MinorArcana/Swords/8OfSwords_0.txt')," +
                "('114', 4, 1, '8 Of Swords','MinorArcana/Swords/8OfSwords_0.png','MinorArcana/Swords/8OfSwords_1.txt')," +
                "('115', 4, 0, '9 Of Swords','MinorArcana/Swords/9OfSwords_0.png','MinorArcana/Swords/9OfSwords_0.txt')," +
                "('116', 4, 1, '9 Of Swords','MinorArcana/Swords/9OfSwords_0.png','MinorArcana/Swords/9OfSwords_1.txt')," +
                "('117', 4, 0, '10 Of Swords','MinorArcana/Swords/10OfSwords_0.png','MinorArcana/Swords/10OfSwords_0.txt')," +
                "('118', 4, 1, '10 Of Swords','MinorArcana/Swords/10OfSwords_0.png','MinorArcana/Swords/10OfSwords_1.txt')," +
                "('119', 4, 0, 'Ace Of Swords','MinorArcana/Swords/AceOfSwords_0.png','MinorArcana/Swords/AceOfSwords_0.txt')," +
                "('120', 4, 1, 'Ace Of Swords','MinorArcana/Swords/AceOfSwords_0.png','MinorArcana/Swords/AceOfSwords_1.txt')," +
                "('121', 4, 0, 'King Of Swords','MinorArcana/Swords/KingOfSwords_0.png','MinorArcana/Swords/KingOfSwords_0.txt')," +
                "('122', 4, 1, 'King Of Swords','MinorArcana/Swords/KingOfSwords_0.png','MinorArcana/Swords/KingOfSwords_1.txt')," +
                "('123', 4, 0, 'Knight Of Swords','MinorArcana/Swords/KnightOfSwords_0.png','MinorArcana/Swords/KnightOfSwords_0.txt')," +
                "('124', 4, 1, 'Knight Of Swords','MinorArcana/Swords/KnightOfSwords_0.png','MinorArcana/Swords/KnightOfSwords_1.txt')," +
                "('125', 4, 0, 'Page Of Swords','MinorArcana/Swords/PageOfSwords_0.png','MinorArcana/Swords/PageOfSwords_0.txt')," +
                "('126', 4, 1, 'Page Of Swords','MinorArcana/Swords/PageOfSwords_0.png','MinorArcana/Swords/PageOfSwords_1.txt')," +
                "('127', 4, 0, 'Queen Of Swords','MinorArcana/Swords/QueenOfSwords_0.png','MinorArcana/Swords/QueenOfSwords_0.txt')," +
                "('128', 4, 1, 'Queen Of Swords','MinorArcana/Swords/QueenOfSwords_0.png','MinorArcana/Swords/QueenOfSwords_1.txt')," +
                "('129', 5, 0, '2 Of Wands','MinorArcana/Wands/2OfWands_0.png','MinorArcana/Wands/2OfWands_0.txt')," +
                "('130', 5, 1, '2 Of Wands','MinorArcana/Wands/2OfWands_0.png','MinorArcana/Wands/2OfWands_1.txt')," +
                "('131', 5, 0, '3 Of Wands','MinorArcana/Wands/3OfWands_0.png','MinorArcana/Wands/3OfWands_0.txt')," +
                "('132', 5, 1, '3 Of Wands','MinorArcana/Wands/3OfWands_0.png','MinorArcana/Wands/3OfWands_1.txt')," +
                "('133', 5, 0, '4 Of Wands','MinorArcana/Wands/4OfWands_0.png','MinorArcana/Wands/4OfWands_0.txt')," +
                "('134', 5, 1, '4 Of Wands','MinorArcana/Wands/4OfWands_0.png','MinorArcana/Wands/4OfWands_1.txt')," +
                "('135', 5, 0, '5 Of Wands','MinorArcana/Wands/5OfWands_0.png','MinorArcana/Wands/5OfWands_0.txt')," +
                "('136', 5, 1, '5 Of Wands','MinorArcana/Wands/5OfWands_0.png','MinorArcana/Wands/5OfWands_1.txt')," +
                "('137', 5, 0, '6 Of Wands','MinorArcana/Wands/6OfWands_0.png','MinorArcana/Wands/6OfWands_0.txt')," +
                "('138', 5, 1, '6 Of Wands','MinorArcana/Wands/6OfWands_0.png','MinorArcana/Wands/6OfWands_1.txt')," +
                "('139', 5, 0, '7 Of Wands','MinorArcana/Wands/7OfWands_0.png','MinorArcana/Wands/7OfWands_0.txt')," +
                "('140', 5, 1, '7 Of Wands','MinorArcana/Wands/7OfWands_0.png','MinorArcana/Wands/7OfWands_1.txt')," +
                "('141', 5, 0, '8 Of Wands','MinorArcana/Wands/8OfWands_0.png','MinorArcana/Wands/8OfWands_0.txt')," +
                "('142', 5, 1, '8 Of Wands','MinorArcana/Wands/8OfWands_0.png','MinorArcana/Wands/8OfWands_1.txt')," +
                "('143', 5, 0, '9 Of Wands','MinorArcana/Wands/9OfWands_0.png','MinorArcana/Wands/9OfWands_0.txt')," +
                "('144', 5, 1, '9 Of Wands','MinorArcana/Wands/9OfWands_0.png','MinorArcana/Wands/9OfWands_1.txt')," +
                "('145', 5, 0, '10 Of Wands','MinorArcana/Wands/10OfWands_0.png','MinorArcana/Wands/10OfWands_0.txt')," +
                "('146', 5, 1, '10 Of Wands','MinorArcana/Wands/10OfWands_0.png','MinorArcana/Wands/10OfWands_0.txt')," +
                "('147', 5, 0, 'Ace Of Wands','MinorArcana/Wands/AceOfWands_0.png','MinorArcana/Wands/AceOfWands_0.txt')," +
                "('148', 5, 1, 'Ace Of Wands','MinorArcana/Wands/AceOfWands_0.png','MinorArcana/Wands/AceOfWands_0.txt')," +
                "('149', 5, 0, 'King Of Wands','MinorArcana/Wands/KingOfWands_0.png','MinorArcana/Wands/KingOfWands_0.txt')," +
                "('150', 5, 1, 'King Of Wands','MinorArcana/Wands/KingOfWands_0.png','MinorArcana/Wands/KingOfWands_1.txt')," +
                "('151', 5, 0, 'Knight Of Wands','MinorArcana/Wands/KnightOfWands_0.png','MinorArcana/Wands/KnightOfWands_0.txt')," +
                "('152', 5, 1, 'Knight Of Wands','MinorArcana/Wands/KnightOfWands_0.png','MinorArcana/Wands/KnightOfWands_1.txt')," +
                "('153', 5, 0, 'Page Of Wands','MinorArcana/Wands/PageOfWands_0.png','MinorArcana/Wands/PageOfWands_0.txt')," +
                "('154', 5, 1, 'Page Of Wands','MinorArcana/Wands/PageOfWands_0.png','MinorArcana/Wands/PageOfWands_1.txt')," +
                "('155', 5, 0, 'Queen Of Wands','MinorArcana/Wands/QueenOfWands_0.png','MinorArcana/Wands/QueenOfWands_0.txt')," +
                "('156', 5, 1, 'Queen Of Wands','MinorArcana/Wands/QueenOfWands_0.png','MinorArcana/Wands/QueenOfWands_1.txt')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
