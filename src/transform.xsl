<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:key name="typeKey" match="Plane" use="Chars/Type"/>

    <xsl:template match="/">
        <root>
            <xsl:for-each select="Plane[generate-id() = generate-id(key('typeKey', Chars/Type)[1])]">
                <xsl:variable name="currentType" select="Chars/Type"/>
                <xsl:element name="{$currentType}">
                    <xsl:for-each select="key('typeKey', $currentType)">
                        <item>
                            <xsl:value-of select="Model"/>
                        </item>
                    </xsl:for-each>
                </xsl:element>
            </xsl:for-each>
        </root>
    </xsl:template>
</xsl:stylesheet>
