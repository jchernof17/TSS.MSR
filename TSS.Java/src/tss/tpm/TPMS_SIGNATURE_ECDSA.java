package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** Table 187 Definition of {ECC} TPMS_SIGNATURE_ECC Structure */
public class TPMS_SIGNATURE_ECDSA extends TPMS_SIGNATURE_ECC
{
    public TPMS_SIGNATURE_ECDSA() {}

    /** @param _hash The hash algorithm used in the signature process
     *         TPM_ALG_NULL is not allowed.
     *  @param _signatureR TBD
     *  @param _signatureS TBD
     */
    public TPMS_SIGNATURE_ECDSA(TPM_ALG_ID _hash, byte[] _signatureR, byte[] _signatureS)
    {
        super(_hash, _signatureR, _signatureS);
    }

    /** TpmUnion method */
    public TPM_ALG_ID GetUnionSelector() { return TPM_ALG_ID.ECDSA; }

    /** @deprecated Use {@link #toBytes()} instead
     *  @return Wire (marshaled) representation of this object
     */
    public byte[] toTpm () { return toBytes(); }

    /** Static marshaling helper
     *  @param byteBuf Wire representation of the object
     *  @return New object constructed from its wire representation
     */
    public static TPMS_SIGNATURE_ECDSA fromBytes (byte[] byteBuf) 
    {
        return new TpmBuffer(byteBuf).createObj(TPMS_SIGNATURE_ECDSA.class);
    }

    /** @deprecated Use {@link #fromBytes(byte[])} instead
     *  @param byteBuf Wire representation of the object
     *  @return New object constructed from its wire representation
     */
    public static TPMS_SIGNATURE_ECDSA fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }

    /** Static marshaling helper
     *  @param buf Wire representation of the object
     *  @return New object constructed from its wire representation
     */
    public static TPMS_SIGNATURE_ECDSA fromTpm (TpmBuffer buf) 
    {
        return buf.createObj(TPMS_SIGNATURE_ECDSA.class);
    }

    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPMS_SIGNATURE_ECDSA");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
}

//<<<
