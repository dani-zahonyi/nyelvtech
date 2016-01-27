<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version = "1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">

    <xsl:template match="/">
        <html>
            <head>
                <title>
                    Családfa
                </title>
            </head>
            <body>
                <h1>
                    A családfa tagjai születés szerint rendezve:
                </h1>

                <xsl:apply-templates/>
            </body></html>
    </xsl:template>
    <xsl:template match="csaladfa">
    <xsl:apply-templates select="szemely">
        <xsl:sort select="./szuletesi_ido" order="ascending"/>
    </xsl:apply-templates>
    </xsl:template>
    <xsl:template match="szemely">

        <xsl:choose>
            <xsl:when test="@sex = 'no'">
                <i><xsl:apply-templates/></i>
                <p>nő</p> <br/>
                <br/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:apply-templates/>

                <p>férfi</p> <br/>
                <br/>
            </xsl:otherwise>
        </xsl:choose>



    </xsl:template>

    <xsl:template match="nev">
        <h2>
            <xsl:apply-templates/>            </h2>


    </xsl:template>

    <xsl:template match="vezeteknev">
        <xsl:value-of select="."/><xsl:text> </xsl:text>
    </xsl:template>
    <xsl:template match="keresztnev">
            <xsl:value-of select="."/><xsl:text> </xsl:text>
    </xsl:template>

<xsl:template match="szuletesi_ido">

    <b>Született: </b>
    <xsl:value-of select="."/>

</xsl:template>

</xsl:stylesheet>
