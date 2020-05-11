package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command returns a digital signature of the audit session digest. */
public class TPM2_GetSessionAuditDigest_REQUEST extends TpmStructure
{
    /**
     *  handle of the privacy administrator (TPM_RH_ENDORSEMENT)
     *  Auth Index: 1
     *  Auth Role: USER
     */
    public TPM_HANDLE privacyAdminHandle;
    
    /**
     *  handle of the signing key
     *  Auth Index: 2
     *  Auth Role: USER
     */
    public TPM_HANDLE signHandle;
    
    /**
     *  handle of the audit session
     *  Auth Index: None
     */
    public TPM_HANDLE sessionHandle;
    
    /** user-provided qualifying data may be zero-length */
    public byte[] qualifyingData;
    public TPM_ALG_ID inSchemeScheme() { return inScheme != null ? inScheme.GetUnionSelector() : TPM_ALG_ID.NULL; }
    
    /** signing scheme to use if the scheme for signHandle is TPM_ALG_NULL */
    public TPMU_SIG_SCHEME inScheme;
    
    public TPM2_GetSessionAuditDigest_REQUEST()
    {
        privacyAdminHandle = new TPM_HANDLE();
        signHandle = new TPM_HANDLE();
        sessionHandle = new TPM_HANDLE();
    }

    /**
     *  @param _privacyAdminHandle handle of the privacy administrator (TPM_RH_ENDORSEMENT)
     *         Auth Index: 1
     *         Auth Role: USER
     *  @param _signHandle handle of the signing key
     *         Auth Index: 2
     *         Auth Role: USER
     *  @param _sessionHandle handle of the audit session
     *         Auth Index: None
     *  @param _qualifyingData user-provided qualifying data may be zero-length
     *  @param _inScheme signing scheme to use if the scheme for signHandle is TPM_ALG_NULL
     *         (One of [TPMS_SIG_SCHEME_RSASSA, TPMS_SIG_SCHEME_RSAPSS, TPMS_SIG_SCHEME_ECDSA,
     *         TPMS_SIG_SCHEME_ECDAA, TPMS_SIG_SCHEME_SM2, TPMS_SIG_SCHEME_ECSCHNORR, TPMS_SCHEME_HMAC,
     *         TPMS_SCHEME_HASH, TPMS_NULL_SIG_SCHEME])
     */
    public TPM2_GetSessionAuditDigest_REQUEST(TPM_HANDLE _privacyAdminHandle, TPM_HANDLE _signHandle, TPM_HANDLE _sessionHandle, byte[] _qualifyingData, TPMU_SIG_SCHEME _inScheme)
    {
        privacyAdminHandle = _privacyAdminHandle;
        signHandle = _signHandle;
        sessionHandle = _sessionHandle;
        qualifyingData = _qualifyingData;
        inScheme = _inScheme;
    }

    @Override
    public void toTpm(OutByteBuf buf) 
    {
        privacyAdminHandle.toTpm(buf);
        signHandle.toTpm(buf);
        sessionHandle.toTpm(buf);
        buf.writeSizedByteBuf(qualifyingData);
        inScheme.GetUnionSelector().toTpm(buf);
        ((TpmMarshaller)inScheme).toTpm(buf);
    }

    @Override
    public void initFromTpm(InByteBuf buf)
    {
        privacyAdminHandle = TPM_HANDLE.fromTpm(buf);
        signHandle = TPM_HANDLE.fromTpm(buf);
        sessionHandle = TPM_HANDLE.fromTpm(buf);
        int _qualifyingDataSize = buf.readShort() & 0xFFFF;
        qualifyingData = new byte[_qualifyingDataSize];
        buf.readArrayOfInts(qualifyingData, 1, _qualifyingDataSize);
        int _inSchemeScheme = buf.readShort() & 0xFFFF;
        inScheme = UnionFactory.create("TPMU_SIG_SCHEME", new TPM_ALG_ID(_inSchemeScheme));
        inScheme.initFromTpm(buf);
    }

    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.getBuf();
    }

    public static TPM2_GetSessionAuditDigest_REQUEST fromTpm (byte[] x) 
    {
        TPM2_GetSessionAuditDigest_REQUEST ret = new TPM2_GetSessionAuditDigest_REQUEST();
        InByteBuf buf = new InByteBuf(x);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }

    public static TPM2_GetSessionAuditDigest_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_GetSessionAuditDigest_REQUEST ret = new TPM2_GetSessionAuditDigest_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }

    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_GetSessionAuditDigest_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }

    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "privacyAdminHandle", privacyAdminHandle);
        _p.add(d, "TPM_HANDLE", "signHandle", signHandle);
        _p.add(d, "TPM_HANDLE", "sessionHandle", sessionHandle);
        _p.add(d, "byte", "qualifyingData", qualifyingData);
        _p.add(d, "TPMU_SIG_SCHEME", "inScheme", inScheme);
    }
}

//<<<
