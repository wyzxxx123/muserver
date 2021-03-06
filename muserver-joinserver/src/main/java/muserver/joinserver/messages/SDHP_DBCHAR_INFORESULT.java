package muserver.joinserver.messages;

import com.google.auto.value.AutoValue;
import muserver.common.messages.AbstractPacket;
import muserver.common.Globals;
import muserver.common.messages.PWMSG_HEAD;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static muserver.common.utils.EndianUtils.*;

/*
typedef struct
{
	PWMSG_HEAD	h;
	BYTE  result;
	short Number;
	char  AccountID[MAX_IDSTRING];
	char  Name[MAX_IDSTRING+1];	// АМё§
	BYTE  Class;				// Бчѕч
	short Level;				// ·№є§
	int	  LevelUpPoint;			// ·№є§ѕч ЖчАОЖ®
	int   Exp;					// °жЗиДЎ
	int   NextExp;				// ґЩАЅ °жЗиДЎ
	int   Money;				// µ·
	short Str;					// Иы
	short Dex;					// №ОГёјєg
	short Vit;					// °З°­
	short Energy;				// їЎіКБц
	short Life;					// ЗцАз »эён
	short MaxLife;				// ЗцАз ГЦґл »эён°Є
	short Mana;					// ЗцАз ё¶іЄ
	short MaxMana;				// ЗцАз ГЦґл ё¶іЄ°Є
	BYTE  dbInventory[MAX_DBINVENTORY];	// ѕЖАМЕЫ АОєҐЕдё®
	BYTE  dbMagicList[MAX_DBMAGIC];		// ё¶№э(ЅєЕі)ё®ЅєЖ®
	BYTE  MapNumber;			// ё¶Бцё· БўБѕ ЗЯА»¶§АЗ ёК №шИЈ
	BYTE  MapX;					// ё¶Бцё· БўБѕ ЗЯА»¶§АЗ X БВЗҐ
	BYTE  MapY;					// ё¶Бцё· БўБѕ ЗЯА»¶§АЗ Y БВЗҐ
	BYTE  Dir;
	int   PkCount;
	int   PkLevel;
	int   PkTime;
} SDHP_DBCHAR_INFORESULT, *LPSDHP_DBCHAR_INFORESULT;
 */

@AutoValue
public abstract class SDHP_DBCHAR_INFORESULT extends AbstractPacket<SDHP_DBCHAR_INFORESULT> {
    public static Builder builder() {
        return new AutoValue_SDHP_DBCHAR_INFORESULT.Builder();
    }

    public static SDHP_DBCHAR_INFORESULT create(PWMSG_HEAD header, Byte result, Short number, String accountId, String name, Byte clazz, Short level, Integer levelUpPoint, Integer exp, Integer nextExp, Integer money, Short str, Short dex, Short vit, Short energy, Short life, Short maxLife, Short mana, Short maxMana, byte[] dbInventory, byte[] dbMagicList, Byte mapNumber, Byte mapX, Byte mapY, Byte dir, Integer pkCount, Integer pkLevel, Integer pkTime) {
        return builder()
                .header(header)
                .result(result)
                .number(number)
                .accountId(accountId)
                .name(name)
                .clazz(clazz)
                .level(level)
                .levelUpPoint(levelUpPoint)
                .exp(exp)
                .nextExp(nextExp)
                .money(money)
                .str(str)
                .dex(dex)
                .vit(vit)
                .energy(energy)
                .life(life)
                .maxLife(maxLife)
                .mana(mana)
                .maxMana(maxMana)
                .dbInventory(dbInventory)
                .dbMagicList(dbMagicList)
                .mapNumber(mapNumber)
                .mapX(mapX)
                .mapY(mapY)
                .dir(dir)
                .pkCount(pkCount)
                .pkLevel(pkLevel)
                .pkTime(pkTime)
                .build();
    }

    public static SDHP_DBCHAR_INFORESULT deserialize(ByteArrayInputStream stream) throws IOException {
        PWMSG_HEAD header = PWMSG_HEAD.deserialize(stream);

        return SDHP_DBCHAR_INFORESULT.create(
                header,
                readByte(stream),
                readShortBE(stream),
                new String(readBytes(stream, Globals.MAX_IDSTRING)),
                new String(readBytes(stream, Globals.MAX_IDSTRING + 1)),
                readByte(stream),
                readShortBE(stream),
                readIntegerBE(stream),
                readIntegerBE(stream),
                readIntegerBE(stream),

                readIntegerBE(stream),
                readShortBE(stream),
                readShortBE(stream),
                readShortBE(stream),
                readShortBE(stream),
                readShortBE(stream),
                readShortBE(stream),
                readShortBE(stream),
                readShortBE(stream),
                readBytes(stream, Globals.MAX_DBINVENTORY),
                readBytes(stream, Globals.MAX_DBMAGIC),
                readByte(stream),
                readByte(stream),
                readByte(stream),
                readByte(stream),
                readIntegerBE(stream),
                readIntegerBE(stream),
                readIntegerBE(stream)
        );
    }

    public abstract PWMSG_HEAD header();

    public abstract Byte result();

    public abstract Short number();

    public abstract String accountId();

    public abstract String name();

    public abstract Byte clazz();

    public abstract Short level();

    public abstract Integer levelUpPoint();

    public abstract Integer exp();

    public abstract Integer nextExp();

    public abstract Integer money();

    public abstract Short str();

    public abstract Short dex();

    public abstract Short vit();

    public abstract Short energy();

    public abstract Short life();

    public abstract Short maxLife();

    public abstract Short mana();

    public abstract Short maxMana();

    public abstract byte[] dbInventory();

    public abstract byte[] dbMagicList();

    public abstract Byte mapNumber();

    public abstract Byte mapX();

    public abstract Byte mapY();

    public abstract Byte dir();

    public abstract Integer pkCount();

    public abstract Integer pkLevel();

    public abstract Integer pkTime();

    @Override
    public byte[] serialize(ByteArrayOutputStream stream) throws IOException {
        header().serialize(stream);
        writeByte(stream, result());
        writeShortLE(stream, number());
        writeString(stream, accountId(), Globals.MAX_IDSTRING);
        writeString(stream, name(), Globals.MAX_IDSTRING + 1);
        writeByte(stream, clazz());
        writeShortLE(stream, level());
        writeIntegerLE(stream, levelUpPoint());
        writeIntegerLE(stream, exp());
        writeIntegerLE(stream, nextExp());
        writeIntegerLE(stream, money());
        writeShortLE(stream, str());
        writeShortLE(stream, dex());
        writeShortLE(stream, vit());
        writeShortLE(stream, energy());
        writeShortLE(stream, life());
        writeShortLE(stream, maxLife());
        writeShortLE(stream, mana());
        writeShortLE(stream, maxMana());
        writeBytes(stream, dbInventory());
        writeBytes(stream, dbMagicList());
        writeByte(stream, mapNumber());
        writeByte(stream, mapX());
        writeByte(stream, mapY());
        writeByte(stream, dir());
        writeIntegerLE(stream, pkCount());
        writeIntegerLE(stream, pkLevel());
        writeIntegerLE(stream, pkTime());
        return stream.toByteArray();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder header(PWMSG_HEAD header);

        public abstract Builder result(Byte result);

        public abstract Builder number(Short number);

        public abstract Builder accountId(String accountId);

        public abstract Builder name(String name);

        public abstract Builder clazz(Byte clazz);

        public abstract Builder level(Short level);

        public abstract Builder levelUpPoint(Integer levelUpPoint);

        public abstract Builder exp(Integer exp);

        public abstract Builder nextExp(Integer nextExp);

        public abstract Builder money(Integer money);

        public abstract Builder str(Short str);

        public abstract Builder dex(Short dex);

        public abstract Builder vit(Short vit);

        public abstract Builder energy(Short energy);

        public abstract Builder life(Short life);

        public abstract Builder maxLife(Short maxLife);

        public abstract Builder mana(Short mana);

        public abstract Builder maxMana(Short maxMana);

        public abstract Builder dbInventory(byte[] dbInventory);

        public abstract Builder dbMagicList(byte[] dbMagicList);

        public abstract Builder mapNumber(Byte mapNumber);

        public abstract Builder mapX(Byte mapX);

        public abstract Builder mapY(Byte mapY);

        public abstract Builder dir(Byte dir);

        public abstract Builder pkCount(Integer pkCount);

        public abstract Builder pkLevel(Integer pkLevel);

        public abstract Builder pkTime(Integer pkTime);

        public abstract SDHP_DBCHAR_INFORESULT build();
    }
}
