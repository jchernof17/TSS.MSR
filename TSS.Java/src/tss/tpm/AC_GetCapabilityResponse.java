package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/**
 *  The purpose of this command is to obtain information about an Attached Component
 *  referenced by an AC handle.
 */
public class AC_GetCapabilityResponse extends TpmStructure
{
    /** flag to indicate whether there are more values */
    public byte moreData;
    
    /** list of capabilities */
    public TPMS_AC_OUTPUT[] capabilitiesData;
    
    public AC_GetCapabilityResponse() {}
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeByte(moreData);
        buf.writeObjArr(capabilitiesData);
    }

    @Override
    public void initFromTpm(InByteBuf buf)
    {
        moreData = buf.readByte();
        int _capabilitiesDataCount = buf.readInt();
        capabilitiesData = new TPMS_AC_OUTPUT[_capabilitiesDataCount];
        for (int j=0; j < _capabilitiesDataCount; j++) capabilitiesData[j] = new TPMS_AC_OUTPUT();
        buf.readArrayOfTpmObjects(capabilitiesData, _capabilitiesDataCount);
    }

    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.getBuf();
    }

    public static AC_GetCapabilityResponse fromTpm (byte[] x) 
    {
        AC_GetCapabilityResponse ret = new AC_GetCapabilityResponse();
        InByteBuf buf = new InByteBuf(x);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }

    public static AC_GetCapabilityResponse fromTpm (InByteBuf buf) 
    {
        AC_GetCapabilityResponse ret = new AC_GetCapabilityResponse();
        ret.initFromTpm(buf);
        return ret;
    }

    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_AC_GetCapability_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }

    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "moreData", moreData);
        _p.add(d, "TPMS_AC_OUTPUT", "capabilitiesData", capabilitiesData);
    }
}

//<<<
